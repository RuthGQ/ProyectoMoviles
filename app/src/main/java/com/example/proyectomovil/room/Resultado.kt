package com.example.proyectomovil.room

import kotlin.Error


sealed class Resultado<out T : Any> {

    data class Success<out T : Any>(val data : T) : Resultado<T>()
    data class Error(val exception: Exception) : Resultado<Nothing>()

    override fun toString(): String {
        return when (this){
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}