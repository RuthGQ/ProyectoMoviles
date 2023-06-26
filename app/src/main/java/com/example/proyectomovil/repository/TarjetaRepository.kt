package com.example.proyectomovil.repository

import androidx.lifecycle.LiveData
import com.example.proyectomovil.entity.TarjetaEntity
import com.example.proyectomovil.room.dao.TarjetaDao
import kotlinx.coroutines.flow.Flow

class TarjetaRepository (private val tarjetaDao: TarjetaDao) {

    fun obtenerTarjetas() : Flow<List<TarjetaEntity>>{
        return tarjetaDao.obtenerTarjetas()
    }

    fun obtenerTarjeta(id: String) : LiveData<TarjetaEntity>{
        return tarjetaDao.obtenerTarjetaPorId(id)
    }

    suspend fun insertarTarjeta(tarjeta : TarjetaEntity){
        tarjetaDao.agregarTarjeta(tarjeta)
    }

    suspend fun actualizarTarjeta(tarjeta: TarjetaEntity){
        tarjetaDao.actualizarTarjeta(tarjeta)
    }

    suspend fun eliminarTarjeta(tarjetaEntity: TarjetaEntity){
        tarjetaDao.eliminarTarjeta(tarjetaEntity)
    }
}