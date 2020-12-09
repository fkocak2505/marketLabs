package com.fkocak.changeicondynamiclly

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isChangeIcon = Random.nextBoolean()
        val changeIconNumber = (0 until 3).random()
        if (isChangeIcon)
            changeIcon(changeIconNumber)
        else
            Toast.makeText(applicationContext, "Değiştirilmedi", Toast.LENGTH_SHORT).show()
    }

    private fun changeIcon(iconNumber: Int) {
        when (iconNumber) {
            0 -> {
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, OneLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, TwoLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, ThreeLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)

                Toast.makeText(applicationContext, "Değiştirildi 1", Toast.LENGTH_LONG).show()
            }
            1 -> {
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, TwoLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, OneLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, ThreeLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)

                Toast.makeText(applicationContext, "Değiştirildi 2", Toast.LENGTH_LONG).show()
            }
            2 -> {
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, ThreeLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, OneLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)
                packageManager.setComponentEnabledSetting(ComponentName(this@MainActivity, TwoLauncherAlias::class.java), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP)

                Toast.makeText(applicationContext, "Değiştirildi 3", Toast.LENGTH_LONG).show()
            }
        }
    }
}