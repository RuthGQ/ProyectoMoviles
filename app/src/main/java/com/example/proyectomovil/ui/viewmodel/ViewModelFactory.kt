package com.example.proyectomovil.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyectomovil.repository.TarjetaRepository
import com.example.proyectomovil.repository.UsuarioRepository
import com.example.proyectomovil.ui.ActivityViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(val tarjetaRepository: TarjetaRepository?=null, val usuarioRepository: UsuarioRepository?=null): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TarjetaViewModel::class.java)){
            return tarjetaRepository?.let { TarjetaViewModel(it) } as T
        }
        if(modelClass.isAssignableFrom(UsuarioViewModel::class.java)){
            return usuarioRepository?.let { UsuarioViewModel(it) } as T

        }
        if (modelClass.isAssignableFrom(ActivityViewModel::class.java)){
            return ActivityViewModel() as T
        }
        throw IllegalArgumentException("No corresponde a ningun ViewModel")
    }
}