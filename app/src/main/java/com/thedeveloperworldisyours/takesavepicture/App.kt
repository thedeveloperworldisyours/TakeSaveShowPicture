package com.thedeveloperworldisyours.takesavepicture

import android.app.Application
import com.thedeveloperworldisyours.takesavepicture.data.Prefs

class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}