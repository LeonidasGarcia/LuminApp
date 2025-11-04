package com.luminteam.lumin.ui.layout

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite

data class BarItem(
    val title: String,
    val icon: Int,
    val action: () -> Unit
)


@Composable
fun BottomBar(
    navigateHome: () -> Unit,
    navigateProfile: () -> Unit,
    navigateLevel: () -> Unit
) {

    var currentRoute by remember { mutableStateOf("SectionsScreen") }

    val barItems = listOf(
        BarItem("MainScreen", R.drawable.home_icon, navigateHome),
        BarItem("SectionsScreen", R.drawable.brain_icon, navigateLevel),
        BarItem("ProfileScreen", R.drawable.user_icon, navigateProfile)
    )

    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        containerColor = LuminDarkGray,
    ) {
        barItems.forEach { (title, icon, action) ->
            NavigationBarItem(
                selected = currentRoute == title,
                onClick = {
                    if (currentRoute != title) {
                        currentRoute = title
                        action()
                    }

                },
                icon = {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = title,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = LuminCyan,
                    selectedIndicatorColor = LuminBackground,
                    unselectedIconColor = LuminLightGray,
                    selectedTextColor = LuminWhite,
                    unselectedTextColor = LuminWhite,
                    disabledTextColor = LuminWhite,
                    disabledIconColor = LuminCyan
                )
            )
        }
    }
}