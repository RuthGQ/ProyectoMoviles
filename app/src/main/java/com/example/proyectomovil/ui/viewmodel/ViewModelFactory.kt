package com.example.proyectomovil.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyectomovil.repository.TarjetaRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(val tarjetaRepository: TarjetaRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TarjetaViewModel::class.java)){
            return TarjetaViewModel(tarjetaRepository) as T
        }
        throw IllegalArgumentException("No corresponde a ningun ViewModel")
    }
}