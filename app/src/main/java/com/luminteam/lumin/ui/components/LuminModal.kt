package com.luminteam.lumin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminWhite

@Preview(showSystemUi = false)
@Composable
fun LuminModal(
    modifier: Modifier = Modifier,
    isShown: Boolean = true,
    title: String = "Titulo",
    description: String = "Texto de descripcion",
    confirmText: String = "Confirmar",
    cancelText: String = "Cancelar",
    onConfirm: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    confirmColor: Color = LuminRed,
    confirmTextColor: Color = LuminWhite,
) {
    if (isShown) {
        Dialog(
            onDismissRequest = onDismissRequest,
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = LuminBackground
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(20.dp)
                ) {
                    TitleText(text = title)
                    ParagraphText(text = description)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        LuminSmallButton(
                            text = cancelText,
                            textColor = LuminWhite,
                            buttonColor = LuminDarkGray,
                            onClick = onDismissRequest
                        )
                        LuminSmallButton(
                            text = confirmText,
                            textColor = confirmTextColor,
                            buttonColor = confirmColor,
                            onClick = {
                                onConfirm()
                                onDismissRequest()
                            }
                        )
                    }
                }
            }
        }
    }
}