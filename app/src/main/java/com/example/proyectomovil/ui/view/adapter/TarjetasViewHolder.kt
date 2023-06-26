package com.example.proyectomovil.ui.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.databinding.ItemTarjetasBinding
import com.example.proyectomovil.entity.TarjetaEntity

class TarjetasViewHolder (private val binding: ItemTarjetasBinding) : RecyclerView.ViewHolder(binding.root) {

    fun cargarDatos(tarjeta: TarjetaEntity){
        binding.textTarjetaPropietario.text = tarjeta.propietario
        binding.textTarjetaNumero.text= tarjeta.numero.toString()
        binding.textTarjetaCvv.text=tarjeta.cvv.toString()
        binding.textTarjetaFecha.text=tarjeta.fecha
    }
}