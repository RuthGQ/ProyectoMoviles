package com.example.proyectomovil.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.databinding.ItemTarjetasBinding
import com.example.proyectomovil.entity.TarjetaEntity

class TarjetaAdapter(val onClick:(TarjetaEntity) -> Unit) : RecyclerView.Adapter<TarjetasViewHolder>() {

    private var lista = mutableListOf<TarjetaEntity>()

    fun cargarLista(list: List<TarjetaEntity>){
        lista.addAll(list)
        notifyDataSetChanged()
    }

    fun clean(){
        lista.clear()
    }

    fun cargarItem(item: TarjetaEntity){
        lista.add(item)
        notifyItemInserted(lista.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetasViewHolder {
        val binding = ItemTarjetasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TarjetasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TarjetasViewHolder, position: Int) {
        val tarjeta = lista[position]
        holder.cargarDatos(tarjeta)
        holder.itemView.setOnClickListener{
            onClick(tarjeta)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}