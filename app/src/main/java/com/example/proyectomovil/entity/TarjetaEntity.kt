package com.example.proyectomovil.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_tarjeta")
class TarjetaEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idTarjeta")
    val id:Int=0,

    @ColumnInfo(name = "nombreProp")
    val propietario:String?,

    @ColumnInfo(name = "numeroTarj")
    val numero:Long,

    @ColumnInfo(name = "cvv")
    val cvv:Int,

    @ColumnInfo(name = "fechaTarj")
    val fecha:String?,
    ): Serializable{

    override fun toString(): String {
        return "TarjetaEntity(id='$id', propietario='$propietario', numero='$numero', cvv='$cvv', fecha='$fecha')"
    }

}