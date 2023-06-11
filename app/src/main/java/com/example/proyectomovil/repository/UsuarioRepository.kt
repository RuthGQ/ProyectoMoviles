package com.example.proyectomovil.repository

import android.util.Log
import com.example.proyectomovil.entity.UsuarioEntity
import com.example.proyectomovil.room.Resultado
import com.example.proyectomovil.room.dao.UsuarioDao
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class UsuarioRepository (val usuaDao: UsuarioDao){

    val listaUsuario: Flow<List<UsuarioEntity>> = usuaDao.getUsuarios()

     suspend fun agregar(usuario: UsuarioEntity){
        usuaDao.insert(usuario)

    }

     suspend fun actualizar(usuario: UsuarioEntity){
        usuaDao.update(usuario)
    }

    suspend fun eliminar(usuario: UsuarioEntity){
        usuaDao.delete(usuario)
    }

    suspend fun obtenerUsuarioPorUserYClave(username : String, password : String) : Resultado<UsuarioEntity>{
        return try{
            val usuario = usuaDao.obtenerUsuarioPorUseryClave(username, password)
            Log.i("repositorio", usuario.toString())
            Resultado.Success(usuario)
        }catch (e : Throwable){
            Resultado.Error(Exception("Error en el login", e))
        }
    }

}