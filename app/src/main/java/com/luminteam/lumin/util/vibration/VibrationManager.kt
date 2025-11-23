package com.luminteam.lumin.util.vibration

import android.content.Context
import android.os.VibrationEffect
import android.os.VibratorManager

class VibrationManager(
    private val context: Context
) {
    fun vibrate() {
        val vibrationManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        val vibrator = vibrationManager.defaultVibrator

        if (vibrator.hasVibrator()) {
            vibrator.vibrate(
                VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)
            )
        }
    }
}