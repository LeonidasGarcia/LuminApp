package com.luminteam.lumin.ui.components

import android.content.Context
import android.os.Build
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.annotation.IdRes
import androidx.compose.foundation.clickable
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.TextViewCompat
import coil.ImageLoader
import com.luminteam.lumin.ui.markdown.LuminMarkdownRender
import com.luminteam.lumin.ui.markdown.MarkdownStringBuilder
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import dev.jeziellago.compose.markdowntext.AutoSizeConfig
import dev.jeziellago.compose.markdowntext.CustomTextView
import dev.jeziellago.compose.markdowntext.applyFontFamily
import dev.jeziellago.compose.markdowntext.applyFontResource
import dev.jeziellago.compose.markdowntext.applyFontSize
import dev.jeziellago.compose.markdowntext.applyFontStyle
import dev.jeziellago.compose.markdowntext.applyFontWeight
import dev.jeziellago.compose.markdowntext.applyLineHeight
import dev.jeziellago.compose.markdowntext.applyTextAlign
import dev.jeziellago.compose.markdowntext.applyTextColor
import dev.jeziellago.compose.markdowntext.applyTextDecoration
import dev.jeziellago.compose.markdowntext.enableTextOverflow
import io.noties.markwon.Markwon
import org.w3c.dom.Text

@Composable
fun LuminMarkdownText(
    markdown: String,
    modifier: Modifier = Modifier,
    linkColor: Color = Color.Unspecified,
    truncateOnTextOverflow: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    isTextSelectable: Boolean = false,
    autoSizeConfig: AutoSizeConfig? = null,
    @FontRes fontResource: Int? = null,
    style: TextStyle = TextStyle(LuminWhite),
    @IdRes viewId: Int? = null,
    onClick: (() -> Unit)? = null,
    // this option will disable all clicks on links, inside the markdown text
    // it also enable the parent view to receive the click event
    disableLinkMovementMethod: Boolean = false,
    imageLoader: ImageLoader? = null,
    linkifyMask: Int = Linkify.EMAIL_ADDRESSES or Linkify.PHONE_NUMBERS or Linkify.WEB_URLS,
    enableSoftBreakAddsNewLine: Boolean = true,
    syntaxHighlightColor: Color = Color.LightGray,
    syntaxHighlightTextColor: Color = Color.Unspecified,
    headingBreakColor: Color = Color.Transparent,
    enableUnderlineForLink: Boolean = true,
    importForAccessibility: Int = View.IMPORTANT_FOR_ACCESSIBILITY_AUTO,
    beforeSetMarkdown: ((TextView, Spanned) -> Unit)? = null,
    afterSetMarkdown: ((TextView) -> Unit)? = null,
    onLinkClicked: ((String) -> Unit)? = null,
    onTextLayout: ((numLines: Int) -> Unit)? = null
) {
    val defaultColor: Color = LocalContentColor.current
    val context: Context = LocalContext.current
    val markdownRender: Markwon =
        remember {
            LuminMarkdownRender.create(
                context,
                imageLoader,
                linkifyMask,
                enableSoftBreakAddsNewLine,
                syntaxHighlightColor,
                syntaxHighlightTextColor,
                headingBreakColor,
                enableUnderlineForLink,
                beforeSetMarkdown,
                afterSetMarkdown,
                onLinkClicked,
                style
            )
        }

    val androidViewModifier = if (onClick != null) {
        Modifier
            .clickable { onClick() }
            .then(modifier)
    } else {
        modifier
    }
    AndroidView(
        modifier = androidViewModifier,
        factory = { factoryContext ->
            val linkTextColor = linkColor.takeOrElse { style.color.takeOrElse { defaultColor } }

            CustomTextView(factoryContext).apply {
                viewId?.let { id = viewId }
                fontResource?.let { font -> applyFontResource(font) }
                importantForAccessibility = importForAccessibility

                setMaxLines(maxLines)
                setLinkTextColor(linkTextColor.toArgb())

                setTextIsSelectable(isTextSelectable)

                movementMethod = LinkMovementMethod.getInstance()

                if (truncateOnTextOverflow) enableTextOverflow()

                autoSizeConfig?.let { config ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
                            this,
                            config.autoSizeMinTextSize,
                            config.autoSizeMaxTextSize,
                            config.autoSizeStepGranularity,
                            config.unit
                        )
                    }
                }
            }
        },
        update = { textView: TextView ->
            with(textView) {
                applyTextColor(style.color.takeOrElse { defaultColor }.toArgb())
                applyFontSize(style)
                applyLineHeight(style)
                applyTextDecoration(style)

                with(style) {
                    applyTextAlign(textAlign)
                    fontFamily?.let { applyFontFamily(this) }
                    fontStyle?.let { applyFontStyle(it) }
                    fontWeight?.let { applyFontWeight(it) }
                }
            }
            markdownRender.setMarkdown(textView, markdown)
            if (disableLinkMovementMethod) {
                textView.movementMethod = null
            }
            if (onTextLayout != null) {
                textView.post {
                    onTextLayout(textView.lineCount)
                }
            }
            textView.maxLines = maxLines
        }
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LuminMarkdownTextPreview() {
    LuminTheme {
        LuminMarkdownText(
            markdown = MarkdownStringBuilder()
                .addTitle("Variables y Salidas")
                .addParagraph("Super interesante tema")
                .addSubtitle("Variables")
                .addParagraph("Este es el parrafo del tema")
                .addCode("print('hola mundo')")
                .addOutput("hola mundo")
                .build()
        )
    }
}