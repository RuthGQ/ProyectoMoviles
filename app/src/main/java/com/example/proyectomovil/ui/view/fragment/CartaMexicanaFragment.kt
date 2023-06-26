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
                "Burrito U",
                "Un burrito con 1 carne a elección + nachos\n" +
                        "chips + 2 salsas + gaseosa persona",
                R.drawable.comidamex1
            ),
            CartaFragment.Food(
                "Burrito XT", "Un burrito doble carne a elección + nachos\n" +
                        "chips + 2 salsas + gaseosa personal", R.drawable.comidamex2
            ),
            CartaFragment.Food(
                "Tacos Tex Mex", "3 Tacos Tex Mex con 1 carne a elección con\n" +
                        "crema de frijol + guacamole + queso edam +\n" +
                        "crema agria + pico gallo + cilantro + Nacho\n" +
                        "chips + dos salsas + gaseosa personal", R.drawable.comidamex3
            ),
            CartaFragment.Food(
                "Bowl Chingon",
                "Un bowl con base de arroz mexicano + 2\n" +
                        "carnes a elección + nacho chips + 2 salsas +\n" +
                        "gaseosa persona",
                R.drawable.comidamex4
            ),
            CartaFragment.Food(
                "Fiesta de tacos",
                "Tortillas para tacos: 4 de maiz y 4 de trigo +\n" +
                        "nacho chips + 2 tipos de carne a elección + 6\n" +
                        "salsas y toppings.",
                R.drawable.comidamex5
            ),
            CartaFragment.Food(
                "Antojitos",
                "4 flautas de queso + 4 quesadillas tex-mtex\n" +
                        "de carne molida +\n" +
                        "3 quesadillas mex de pollo asado + 3 grin-\n" +
                        "gas al pastor + nachos chips + 1 tipo de\n" +
                        "carne a elección + 6 salsas y toppings.",
                R.drawable.comidamex6
            ),
            CartaFragment.Food(
                "Chingona",
                "Tortillas para tacos: 4 de maíz y 4 de trigo +\n" +
                        "nachos chips + 3 flautas de queso + 4 quesa-\n" +
                        "dillas tex-mex de carne molida + 3 quesadi-\n" +
                        "llas mex de pollo asado + 2 tipo de carnes a\n" +
                        "elección+ +6 salsas y toppings.",
                R.drawable.comidamex7
            ),
            CartaFragment.Food(
                "El capo",
                "8 tortillas de maíz + pollo al mole poblano +\n" +
                        "birria de res + 2 costras de pastor + queso\n" +
                        "edam + 3 flautas de queso + 2 quesadillas\n" +
                        "mex de pollo + 4 queadillas tex de gorund\n" +
                        "beef + nachos chips + 6 salsas y toppings.",
                R.drawable.comidamex8
            ),
            CartaFragment.Food(
                "Los carnales",
                "Tortillas para tacos: 8 de maíz y 8 de trigo +\n" +
                        "nachos chips+ 4 tipos de cane a elección + 6\n" +
                        "salsas y topping.",
                R.drawable.comidamex9
            ),
            CartaFragment.Food(
                "Gran taquería",
                "Tortillas para tacos: 8 de maíz y 8 de trigo +\n" +
                        "nachos chips + 3 flautas de queso + 4 quesa-\n" +
                        "dillas tex-mex de carness a elección + 3 que-\n" +
                        "sadillas de mex de pollo asado + 4 tipos de\n" +
                        "carnes a elección + 6 salsas y toppings.",
                R.drawable.comidamex10
            ),
            CartaFragment.Food(
                "El patron",
                "3 flautas de queso + 4 quesadillas tex de\n" +
                        "carne molida + 3 quesadillas mex de pollo\n" +
                        "asado + 3 gringas al pastor + 3 enchiladas\n" +
                        "de barbacoa de res (salsa chipotle picante\n" +
                        "medio) + nacho tex de carne molida + 3 tos-\n" +
                        "tadas de maíz + tortillas para tacos: 8 de\n" +
                        "maiz y 8 de trigo + 4 tipos de carne a elec-\n" +
                        "ción + 6 salsas y topping.",
                R.drawable.comidamex11
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