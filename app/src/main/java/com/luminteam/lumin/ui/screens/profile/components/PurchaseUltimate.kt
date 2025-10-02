package com.luminteam.lumin.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun PurchaseUltimate() {
    Column(
        modifier = Modifier
            .background(LuminCyan, shape = RoundedCornerShape(15.dp))
            .padding(20.dp)
            .fillMaxWidth(1f),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "El aprendizaje es mejor con", fontWeight = FontWeight.Bold)
        Column {
            Text(
                text = "Lumin Ultimate",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontWeight = FontWeight.Black,
                color = LuminIntenseGray,
                modifier = Modifier.width(170.dp)
            )
        }
        Text(text = "Iluminate con nuestros planes", fontWeight = FontWeight.Bold)
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(LuminSoftGray),
            contentPadding = PaddingValues(vertical = 0.dp, horizontal = 24.dp)
        ) {
            Text(text = "Ver más", color = LuminWhite, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun PurchaseUltimatePreview() {
    LuminTheme {
        PurchaseUltimate()

    }
}