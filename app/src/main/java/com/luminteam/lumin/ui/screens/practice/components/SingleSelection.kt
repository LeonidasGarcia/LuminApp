package com.luminteam.lumin.ui.screens.practice.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminVerySoftGray

@Composable
fun SingleSelection() {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.weight(1f)) {
            Text(
                text = "Selecciona la respuesa",
                color = LuminWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(modifier = Modifier.weight(1f)) {
                item {
                    LuminMarkdownText(
                        markdown = "Alguna pregunta en markdown xd como estan gente de zona",
                        style = TextStyle(fontSize = 20.sp, color = LuminWhite, lineHeight = 35.sp)
                    )
                }
            }
        }
        Options(options = listOf("Opción 1", "Opción 2", "Opción 3", "Opción 4"))
    }
}

@Composable
fun Options(options: List<String>) {

    var selected by remember { mutableStateOf(0) }

    Row(modifier = Modifier.height(450.dp), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(20.dp)) {
            OptionButton(
                onClick = {
                    selected = 0
                },
                option = options[0],
                selected = selected == 0,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            OptionButton(
                onClick = {
                    selected = 2
                },
                option = options[2],
                selected = selected == 2,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(20.dp)) {

            OptionButton(
                onClick = {
                    selected = 1
                },
                option = options[1],
                selected = selected == 1,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            OptionButton(
                onClick = {
                    selected = 3
                },
                option = options[3],
                selected = selected == 3,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun OptionButton(onClick: () -> Unit, option: String, selected: Boolean, modifier: Modifier) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(if (selected) LuminCyan else LuminSoftGray)
    ) {
        Text(
            text = option,
            color = if (selected) LuminIntenseGray else LuminWhite,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun SingleSelectionPreview() {
    LuminTheme {
        SingleSelection()
    }
}