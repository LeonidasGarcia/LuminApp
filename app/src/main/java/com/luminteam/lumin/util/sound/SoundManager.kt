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

        soundPool.setOnLoadCompleteListener { pool, sampleId, status ->
            if (status == 0) {
                pool.play(sampleId, 0f, 0f, 1, 0, 1f)
            }
        }

        LuminSounds.values().forEach { sound ->
            soundMap[sound] = soundPool.load(context, sound.resId, 1)
        }
    }

    fun play(sound: LuminSounds) {
        val soundId = soundMap[sound] ?: return
        soundPool.play(soundId, 0.85f, 0.85f, 1, 0, 1f)
    }

    fun release() {
        soundPool.release()
    }
}