package com.luminteam.lumin.util.sound

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.luminteam.lumin.R

class SoundManager(
    context: Context
) {
    private val soundPool: SoundPool
    private val clickSoundId: Int

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()

        clickSoundId = soundPool.load(context, R.raw.sfx_tap, 1)
    }

    fun tapSound() {
        soundPool.play(clickSoundId, 1f, 1f, 1, 0, 1f)

    }

    fun release() {
        soundPool.release()
    }
}