package com.example.proyectomovil.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectomovil.entity.TarjetaEntity
import com.example.proyectomovil.repository.TarjetaRepository
import kotlinx.coroutines.launch

class TarjetaViewModel (private val tarjetaRepository: TarjetaRepository): ViewModel() {

    val tarjetas = tarjetaRepository.obtenerTarjetas().asLiveData();

    fun insertar(tarjeta: TarjetaEntity){
        viewModelScope.launch {
            tarjetaRepository.insertarTarjeta(tarjeta)
        }
    }

    fun obtenerTarjeta(id : String) = tarjetaRepository.obtenerTarjeta(id)

    fun actualizar(tarjeta: TarjetaEntity){
        viewModelScope.launch {
            tarjetaRepository.actualizarTarjeta(tarjeta)
        }
    }

    fun eliminar(tarjeta: TarjetaEntity){
        viewModelScope.launch {
            tarjetaRepository.eliminarTarjeta(tarjeta)
        }
    }
}