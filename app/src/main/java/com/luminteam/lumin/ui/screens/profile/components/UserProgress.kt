package com.luminteam.lumin.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun UserProgress() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = "Tu Progreso",
            color = LuminWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Row(
            modifier = Modifier
                .background(LuminDarkGray, shape = RoundedCornerShape(15.dp))
                .padding(vertical = 20.dp, horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(contentAlignment = Alignment.Center) {
                    Column {
                        CircularProgressIndicator(
                            strokeWidth = 5.dp,
                            strokeCap = StrokeCap.Butt,
                            color = LuminCyan,
                            trackColor = LuminLightGray,
                            modifier = Modifier.size(80.dp),
                            progress = { 0.5f }
                        )
                    }
                    Text(
                        text = "100%",
                        color = LuminWhite,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(text = "23/50 secciones", fontSize = 10.sp, color = LuminWhite)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Text(
                    text = "Tu nivel más alto alcanzado ha sido",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = LuminWhite,
                    modifier = Modifier.width(150.dp)
                )
                Text(
                    text = "Básico",
                    color = LuminCyan,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tu promedio de prácticas es",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = LuminWhite
                )
                Text(
                    text = "8.5",
                    color = LuminCyan,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun UserProgressPreview() {
    LuminTheme {
        UserProgress()
    }
}