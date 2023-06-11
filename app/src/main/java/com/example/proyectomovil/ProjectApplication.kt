package com.example.proyectomovil

import android.app.Application
import com.example.proyectomovil.room.module.Preferencias
import dagger.hilt.android.HiltAndroidApp

val prefs: Preferencias by lazy {
    ProjectApplication.prefs!!
}

//@HiltAndroidApp
class ProjectApplication :  Application(){
    companion object {
        var prefs: Preferencias? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferencias(applicationContext)
    }

}