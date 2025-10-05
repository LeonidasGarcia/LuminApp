package com.luminteam.lumin.ui.screens.theory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.components.ReturnButton
import com.luminteam.lumin.ui.markdown.MarkdownStringBuilder
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.R

@Composable
fun TheoryScreen() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item {
            ReturnButton()
        }

        item {
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

        item {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painterResource(R.drawable.arrow_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .rotate(180f),
                        )
                        Text(text = "Anterior")
                    }
                }
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = "Siguiente")
                        Icon(
                            painterResource(R.drawable.arrow_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                        )
                    }
                }
            }
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TheoryScreenPreview() {
    LuminTheme {
        TheoryScreen()
    }
}