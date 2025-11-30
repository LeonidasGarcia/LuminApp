package com.luminteam.lumin.util.sound

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.luminteam.lumin.R

class SoundManager(
    context: Context
) {
    private val soundPool: SoundPool
    private val soundMap = mutableMapOf<LuminSounds, Int>()

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        LuminSounds.values().forEach { sound ->
            soundMap[sound] = soundPool.load(context, sound.resId, 1)
        }
    }

    fun play(sound: LuminSounds) {
        val soundId = soundMap[sound] ?: return
        soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
    }

    fun release() {
        soundPool.release()
    }
}