package com.luminteam.lumin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.Inter
import com.luminteam.lumin.ui.theme.LuminAltGray
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminVerySoftGray

@Preview(showSystemUi = true)
@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Row(
            modifier = Modifier
                .background(
                    color = LuminIntenseGray,
                    shape = RoundedCornerShape(
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp)
                )
                .height(106.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            CurrentPageIndicator()
            Spacer(modifier = Modifier.width(16.dp))
            LuminLogo()
            Spacer(modifier = Modifier.width(16.dp))
            EnergyIndicator()
            Spacer(modifier = Modifier.width(16.dp))
            ActionButton()
            Spacer(modifier = Modifier.width(16.dp))

        }
    }
}


@Preview
@Composable
fun CurrentPageIndicator(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.book_icon),
                contentDescription = "Icono de Libro",
                modifier = Modifier.height(24.dp),
                tint = LuminCyan
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            Text(
                text = "Aprender",
                color = LuminCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
fun EnergyIndicator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "5",
                color = LuminVerySoftGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier
                    .width(4.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.energy_icon),
                contentDescription = "Icono de Libro",
                modifier = Modifier.height(24.dp),
                tint = LuminVerySoftGray
            )
        }
    }
}

@Preview
@Composable
fun ActionButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(45.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.user_icon),
                contentDescription = "Icono de Libro",
                modifier = Modifier.height(24.dp),
                tint = LuminVerySoftGray
            )
        }
    }
}

@Composable
fun LuminLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.lumin_logo),
        contentDescription = "Logo de Lumin",
        modifier = Modifier.height(45.dp)
    )
}