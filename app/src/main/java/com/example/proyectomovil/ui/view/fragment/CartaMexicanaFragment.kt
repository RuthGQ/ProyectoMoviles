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
import com.example.proyectomovil.databinding.FragmentCartaMexicanaBinding

class CartaMexicanaFragment : Fragment() {

    private var _binding: FragmentCartaMexicanaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartaMexicanaBinding.inflate(inflater, container, false)
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
            findNavController().navigate(R.id.action_cartaMexicanaFragment_to_tipoComidaFragment)

        }
    }

    private fun getFoodList(): List<CartaFragment.Food> {
        return listOf(
            CartaFragment.Food(
                "Pruebaa",
                " plato de origen italiano " +
                        "que consiste en capas de pasta de lasaña intercaladas con una mezcla " +
                        "de carne molida, salsa de tomate, queso y hierbas aromáticas. ",
                R.drawable.comida1
            ),
            CartaFragment.Food(
                "Moussaka", " consiste en capas de berenjenas, carne picada de cordero o ternera," +
                        " tomates, cebollas y especias, cubiertas con una bechamel y horneadas" +
                        " hasta que estén doradas.", R.drawable.comida2
            ),
            CartaFragment.Food(
                "Ensalada griega", "Es una ensalada fresca y saludable que" +
                        " combina tomates, pepinos, " +
                        "cebolla roja, aceitunas, queso feta y aderezo de aceite de oliva " +
                        "y limón", R.drawable.comida3
            ),
            CartaFragment.Food(
                "Paella", "Se prepara con arroz, pollo, conejo, mariscos, " +
                        "verduras y especias como el azafrán." +
                        " Es una comida colorida y aromática que representa la" +
                        " esencia de la cocina" +
                        " mediterránea", R.drawable.comida4
            ),
            CartaFragment.Food(
                "Tabulé",
                "Es una ensalada de origen libanés que se hace con" +
                        " bulgur (trigo partido)" +
                        ", tomate, perejil, menta, cebolla, aceite de oliva y jugo de limón. ",
                R.drawable.comida5
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