package com.luminteam.lumin.util.sound

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.luminteam.lumin.data.repository.LocalAppConfig
import com.luminteam.lumin.data.repository.LocalSoundManager

@Composable
fun rememberSoundPlayer(): (LuminSounds) -> Unit {
    val config = LocalAppConfig.current
    val soundManager = LocalSoundManager.current

    return remember(config, soundManager) {
        { sound ->
            if (config.isSfxOn) {
                soundManager.play(sound)
            }
        }
    }
}