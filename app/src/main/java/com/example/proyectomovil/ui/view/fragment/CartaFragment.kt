package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovil.R

class CartaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carta, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val foodList = getFoodList()

        val foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        return view
    }

    private fun getFoodList(): List<Food> {
        return listOf(
            Food("Comida 1", "Descripción de la comida 1", R.drawable.almuerzo2),
            Food("Comida 2", "Descripción de la comida 2", R.drawable.almuerzo2),
            Food("Comida 3", "Descripción de la comida 3", R.drawable.almuerzo2),
            Food("Comida 4", "Descripción de la comida 4", R.drawable.almuerzo2),
            Food("Comida 5", "Descripción de la comida 5", R.drawable.almuerzo2),
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
}