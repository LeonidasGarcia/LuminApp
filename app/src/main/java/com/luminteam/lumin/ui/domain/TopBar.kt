package com.luminteam.lumin.ui.domain

enum class TopBarRightButtonActionType {
    SHOW_LIVES,
    SHOW_AI_CHAT
}

data class TitleTopBar(
    val title: String = "",
    val iconTitle: Int = 0
)

typealias TopBarBackAction = () -> Unit