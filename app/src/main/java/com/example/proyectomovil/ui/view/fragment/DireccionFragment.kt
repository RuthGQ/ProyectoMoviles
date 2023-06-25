package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentDireccionBinding
import com.example.proyectomovil.databinding.FragmentMenuBinding

class DireccionFragment : Fragment()  {

    private var _binding : FragmentDireccionBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDireccionBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = binding.recyclerView3
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val direccionList = getDireccionList()

        val foodAdapter = DireccionAdapter(direccionList)
        recyclerView.adapter = foodAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAgregar.setOnClickListener {
            val action = DireccionFragmentDirections.actionDireccionFragmentToDireccionRegistrarFragment()
            findNavController().navigate(action)
        }
    }

    private fun getDireccionList(): List<CartaFragment.Direccion> {
        return listOf(
            CartaFragment.Direccion(
                "123 Calle Principal, Ciudad",
                "Código Postal: 12345",
                "Lima"
            ),
            CartaFragment.Direccion(
                "456 Avenida Central, Pueblo",
                "Código Postal: 67890",
                "Huancayo"
            ),
            CartaFragment.Direccion(
                "789 Calle Secundaria, Villa",
                "Código Postal: 54321",
                "Arequipa"
            ),
            CartaFragment.Direccion(
                "321 Avenida Norte, Ciudad",
                "Código Postal: 98765",
                "Huánuco"
            ),
            CartaFragment.Direccion(
                "654 Calle Este, Pueblo",
                "Código Postal: 43210",
                "Ica"
            )
        )
    }

    private inner class DireccionAdapter(private val direccionList: List<CartaFragment.Direccion>) :
        RecyclerView.Adapter<DireccionAdapter.direccionViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): direccionViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_direccion, parent, false)
            return direccionViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: direccionViewHolder, position: Int) {
            val currentDireccion = direccionList[position]

            holder.nameTextView.text = currentDireccion.name
            holder.descriptionTextView.text = currentDireccion.description
            holder.provinciaTextView.text = currentDireccion.provincia
        }

        override fun getItemCount(): Int {
            return direccionList.size
        }

        inner class direccionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.lbl_codigo_direccion)
            val descriptionTextView: TextView = itemView.findViewById(R.id.lbl_nombre_direccion)
            val provinciaTextView: TextView = itemView.findViewById(R.id.lbl_provincia_direccion)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}