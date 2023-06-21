package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentCartaBinding
import com.example.proyectomovil.databinding.FragmentPedidoBinding

class CartaFragment : Fragment() {

    private var _binding: FragmentCartaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartaBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val foodList = getFoodList()

        val foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresar4.setOnClickListener {
            findNavController().navigate(R.id.action_cartaFragment_to_tipoComidaFragment)

        }
    }

    private fun getFoodList(): List<Food> {
        return listOf(
            Food("Lasagna de carne gratinada", "Descripción de la comida 1", R.drawable.almuerzo2),
            Food("Comida 2", "Descripción de la comida 2", R.drawable.almuerzo2),
            Food("Comida 3", "Descripción de la comida 3", R.drawable.almuerzo2),
            Food("Comida 4", "Descripción de la comida 4", R.drawable.almuerzo2),
            Food("Comida 5", "Descripción de la comida 5", R.drawable.almuerzo2)
            // Agrega más elementos de comida según sea necesario
        )
    }

    private inner class FoodAdapter(private val foodList: List<Food>) :
        RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_food, parent, false)
            return FoodViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
            val currentFood = foodList[position]

            holder.nameTextView.text = currentFood.name
            holder.descriptionTextView.text = currentFood.description
            holder.imageView.setImageResource(currentFood.imageResId)

            holder.itemView.setOnClickListener {
                findNavController().navigate(R.id.action_carta_to_pedido)
            }
        }

        override fun getItemCount(): Int {
            return foodList.size
        }

        inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.text_food_name)
            val descriptionTextView: TextView = itemView.findViewById(R.id.text_food_description)
            val imageView: ImageView = itemView.findViewById(R.id.image_food)
        }
    }

    data class Food(val name: String, val description: String, val imageResId: Int)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}