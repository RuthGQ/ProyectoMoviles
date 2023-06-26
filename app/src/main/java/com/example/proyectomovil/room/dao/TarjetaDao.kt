package com.example.proyectomovil.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proyectomovil.entity.TarjetaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TarjetaDao {

    @Query("select * from tb_tarjeta")
    fun obtenerTarjetas() : Flow<List<TarjetaEntity>>

    @Query("select * from tb_tarjeta where idTarjeta= :id")
    fun obtenerTarjetaPorId(id:String) : LiveData<TarjetaEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarTarjeta(tarjeta: TarjetaEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun actualizarTarjeta(tarjeta: TarjetaEntity)

    @Delete(entity = TarjetaEntity::class)
    suspend fun eliminarTarjeta(tarjeta: TarjetaEntity)
}