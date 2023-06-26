package com.example.proyectomovil

import android.app.Application
import com.example.proyectomovil.repository.TarjetaRepository
import com.example.proyectomovil.repository.UsuarioRepository
import com.example.proyectomovil.room.AlmacenDatabase
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

    val database by lazy { AlmacenDatabase.getInstance(this) }
    val usuarioDBRepository by lazy {UsuarioRepository(database.usuarioDAO())}
    val tarjetaDBRepository by lazy { TarjetaRepository(database.tarjetaDAO()) }
}