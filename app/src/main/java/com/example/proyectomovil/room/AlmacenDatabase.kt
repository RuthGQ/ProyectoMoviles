package com.example.proyectomovil.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyectomovil.entity.UsuarioEntity
import com.example.proyectomovil.room.dao.UsuarioDao

@Database(entities = [UsuarioEntity::class], version = 1)
abstract class AlmacenDatabase: RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDao

    companion object{
        private var INSTANCE: AlmacenDatabase? = null
        fun getInstance(context: Context):AlmacenDatabase{
            return INSTANCE ?: synchronized(this){
                val obj = Room.databaseBuilder(context, AlmacenDatabase::class.java, "BDArkinka").allowMainThreadQueries().build()
                INSTANCE = obj
                obj
            }
        }
    }
}