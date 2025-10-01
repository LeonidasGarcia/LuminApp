package com.luminteam.lumin.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.screens.main.MainScreen
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminVerySoftGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun ProfileScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(LuminIntenseGray),
            contentPadding = PaddingValues(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painterResource(R.drawable.arrow_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .rotate(180f),
                    tint = LuminVerySoftGray
                )
                Text(text = "Regresar", color = LuminVerySoftGray)
            }
        }
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
                    color = LuminVerySoftGray,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp
                )
                Text(text = "20 años", color = LuminVerySoftGray, fontSize = 12.sp)
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(LuminSoftGray, shape = RoundedCornerShape(10.dp))
        )
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(
                text = "Tu Progreso",
                color = LuminWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Row(
                modifier = Modifier
                    .background(LuminSoftGray, shape = RoundedCornerShape(15.dp))
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
                                trackColor = LuminVerySoftGray,
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(LuminSoftGray, shape = RoundedCornerShape(10.dp))
        )
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
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun ProfileScreenPreview() {
    LuminTheme {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            ProfileScreen()
        }

    }
}