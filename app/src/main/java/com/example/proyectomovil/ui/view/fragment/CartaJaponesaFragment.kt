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
import com.example.proyectomovil.databinding.FragmentCartaJaponesaBinding
import com.example.proyectomovil.databinding.FragmentCartaMexicanaBinding

class CartaJaponesaFragment : Fragment() {

    private var _binding: FragmentCartaJaponesaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartaJaponesaBinding.inflate(inflater, container, false)
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
            findNavController().navigate(R.id.action_cartaJaponesaFragment_to_tipoComidaFragment)

        }
    }

    private fun getFoodList(): List<CartaFragment.Food> {
        return listOf(
            CartaFragment.Food(
                "Sashimi",
                "(4 cortes)\n" +
                        "Salmón\n" +
                        "Atún / Mariscos",
                R.drawable.comidajap1
            ),
            CartaFragment.Food(
                "Poke salmon", "Salmón, mango, kiuri, palta,\n" +
                        "hilos de beterraga y ajonjolí.", R.drawable.comidajap2
            ),
            CartaFragment.Food(
                "Takitos Kaikan", "3 Tacos de tartar de atún con palta\n" +
                        "sobre masa frita.", R.drawable.comidajap3
            ),
            CartaFragment.Food(
                "Tiradito Ponzu",
                "Rollitos de atún fresco y cebolla\n" +
                        "crocante, bañados en salsa ponzu,\n" +
                        "sarsa de kiuri y hoisin.",
                R.drawable.comidajap4
            ),
            CartaFragment.Food(
                "Tiradito emperador",
                "Rollitos de atún fresco y cebolla\n" +
                        "crocante, bañados en salsa ponzu,\n" +
                        "sarsa de kiuri y hoisin.",
                R.drawable.comidajap5
            ),
            CartaFragment.Food(
                "Yakitori",
                "Brochetas de pollo y negi (poro\n" +
                        "japonés) bañados en salsa teriyaki\n" +
                        "(dulce) o salsa de la casa (salada)",
                R.drawable.comidajap6
            ),
            CartaFragment.Food(
                "Bata Niku",
                "Lomo fino en salsa Batayaki de\n" +
                        "romero y miso acompañado de\n" +
                        "cebolla blanca, holantao, ajo\n" +
                        "crocante y puré.",
                R.drawable.comidajap7
            ),
            CartaFragment.Food(
                "Tofu bowl",
                "Bowl de tofu y renkon frito,\n" +
                        "con verduras salteadas en\n" +
                        "miel de sapporo, sobre una\n" +
                        "cama de arroz",
                R.drawable.comidajap8
            ),
            CartaFragment.Food(
                "Katsudon",
                "Lomo de cerdo al panko,\n" +
                        "huevo semi cocido, sobre\n" +
                        "arroz japonés.",
                R.drawable.comidajap9
            ),
            CartaFragment.Food(
                "Tonkatsu",
                "Lomo de cerdo al panko,\n" +
                        "ensalada de col y arroz\n" +
                        "japonés.",
                R.drawable.comidajap10
            ),
            CartaFragment.Food(
                "Yakimeshi",
                "Arroz frito con pollo y\n" +
                        "verduras, envuelta en tortilla\n" +
                        "de huevo, en salsa shiitake.",
                R.drawable.comidajap11
            )


            // Agrega más elementos de comida según sea necesario
        )
    }

    private inner class FoodAdapter(private val foodList: List<CartaFragment.Food>) :
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}