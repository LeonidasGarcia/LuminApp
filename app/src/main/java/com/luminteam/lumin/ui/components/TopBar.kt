package com.luminteam.lumin.ui.components

import androidx.compose.foundation.background
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.Inter
import com.luminteam.lumin.ui.theme.LuminAltGray
import com.luminteam.lumin.ui.theme.LuminCyan


@Preview(
    showSystemUi = false
)
@Composable
fun CurrentPage(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(120.dp)
    ) {
        Row(
            modifier = Modifier

        ) {

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.book_icon),
                contentDescription = "Icono de Libro",
                modifier = Modifier.height(24.dp),
                tint = LuminCyan
            )
            Spacer(modifier = Modifier
                .width(8.dp)
            )
            CurrentPageText()
        }
    }
}

@Composable
fun CurrentPageText() {
    Text(
        text = "Aprender",
        color = LuminCyan,
        fontSize = 12.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
    )
}