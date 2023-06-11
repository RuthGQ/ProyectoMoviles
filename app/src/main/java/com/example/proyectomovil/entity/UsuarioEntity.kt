package com.example.proyectomovil.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_usuario")
class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "nombreUsu")
    val nombre:String?,

    @ColumnInfo(name = "apellidosUsu")
    val apellido:String?,

    @ColumnInfo(name = "correoUsu")
    val correo:String?,

    @ColumnInfo(name = "telefonoUsu")
    val telefono:String?,

    @ColumnInfo(name = "usuario")
    val user:String?,

    @ColumnInfo(name = "claveUsu")
    val clave:String?,

    ):  Serializable{
    override fun toString(): String {
        return "Usuario(id=$id, nombre=$nombre, apellido=$apellido, correo=$correo, telefono=$telefono, user=$user, clave=$clave)"
    }
}