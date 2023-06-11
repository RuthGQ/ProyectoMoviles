package com.example.proyectomovil.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_tarjeta")
class TarjetaEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idTarjeta")
    val id:Int=0,

    @ColumnInfo(name = "numeroTarj")
    val numero:Int,

    @ColumnInfo(name = "fechaTarj")
    val fecha:String?,
    ){


}