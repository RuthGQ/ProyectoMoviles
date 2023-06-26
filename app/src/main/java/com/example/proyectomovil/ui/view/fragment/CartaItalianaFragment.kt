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
import com.example.proyectomovil.databinding.FragmentCartaItalianaBinding

class CartaItalianaFragment : Fragment() {

    private var _binding: FragmentCartaItalianaBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartaItalianaBinding.inflate(inflater, container, false)
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
            findNavController().navigate(R.id.action_cartaItalianaFragment_to_tipoComidaFragment)

        }
    }

    private fun getFoodList(): List<CartaFragment.Food> {
        return listOf(
            CartaFragment.Food(
                "Poker de pastas",
                "Ravioli alla bolognesa, linguini verdi al pesto genovés, " +
                        "fettuccini all´alfredo con jamón inglés y gnocchi en salsa de nueces",
                R.drawable.comidaita1
            ),
            CartaFragment.Food(
                "Penne", "Pasta penne con salsa a eleccion", R.drawable.comidaita2
            ),
            CartaFragment.Food(
                "Ravioles rellenos de champiñones",
                "Rellenos de mixto de champiñones y hongos. En salsa rosada",
                R.drawable.comidaita3
            ),
            CartaFragment.Food(
                "Malfatti de Pollo, Ricota y Nueces",
                "Pasta malfatti con pollo, ricotta, nueces en base de besciamella y punto de pesto",
                R.drawable.comidaita4
            ),
            CartaFragment.Food(
                "Risotto All ´Uso Nostro",
                "Risotto con alcachofas, champiñones, espárragos y pimientos",
                R.drawable.comidaita5
            ),
            CartaFragment.Food(
                "Gnocchi Al Prosciutto Di Parma",
                "Gnocchi de papa amarilla a la panna y jamón crudo italiano laminado y soasado",
                R.drawable.comidaita6
            ),
            CartaFragment.Food(
                "Ensalada Del Césare",
                "Lechugas, yemas de huevo, punto de ajo, perejil, " +
                        "mostaza Dijon, anchoas pasteadas, limón, salsa inglesa, queso parmesano y crutones",
                R.drawable.comidaita7
            ),
            CartaFragment.Food(
                "Raviolones de Berenjena y Ricotta",
                "Lechugas, yemas de huevo, punto de ajo, perejil, " +
                        "mostaza Dijon, anchoas pasteadas, limón, salsa inglesa, queso parmesano y crutones",
                R.drawable.comidaita8
            ),
            CartaFragment.Food(
                "Spaghetti con Pato Affumicato",
                "Pechuga de pato ahumado con demiglace " +
                        "de pato, tomate deshidratado, oliva virgen, finas hierbas",
                R.drawable.comidaita9
            ),
            CartaFragment.Food(
                "Spaghetti a la Puttanesca",
                "Spaghetti con salsa de pimiento y anchoas",
                R.drawable.comidaita10
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