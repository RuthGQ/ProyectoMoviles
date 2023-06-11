package com.example.proyectomovil.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proyectomovil.entity.UsuarioEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM tb_usuario")
    fun getUsuarios(): Flow<List<UsuarioEntity>>

    @Query("SELECT * FROM tb_usuario where usuario = :user and claveUsu= :clave")
    suspend fun obtenerUsuarioPorUseryClave(user: String, clave: String) : UsuarioEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario: UsuarioEntity)

    @Update
    suspend fun update(usuario: UsuarioEntity)

    @Delete
    suspend fun delete(usuario: UsuarioEntity)
}