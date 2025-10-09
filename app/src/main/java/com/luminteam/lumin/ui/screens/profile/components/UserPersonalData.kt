package com.luminteam.lumin.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun UserPersonalData() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Icon(
            painterResource(R.drawable.user_icon),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Leonidas Garcia Lescano",
                color = LuminWhite,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "leonidasgarcia@gmail.com",
                color = LuminLightGray,
                textDecoration = TextDecoration.Underline,
                fontSize = 12.sp
            )
            Text(text = "20 años", color = LuminLightGray, fontSize = 12.sp)
            Box(
                modifier = Modifier
                    .background(LuminCyan, shape = RoundedCornerShape(16.dp))
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Caballero de Plata", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun UserDataPreview() {
    LuminTheme {
        UserPersonalData()
    }
}