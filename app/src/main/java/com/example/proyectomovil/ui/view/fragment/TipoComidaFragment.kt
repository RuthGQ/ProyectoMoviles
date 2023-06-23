package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentTipoComidaBinding

class TipoComidaFragment : Fragment() {

    private var _binding : FragmentTipoComidaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTipoComidaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresar3.setOnClickListener {
            var action = TipoComidaFragmentDirections.actionTipoComidaFragmentToComidaFragment()
            findNavController().navigate(action)
        }

        binding.btnMediterranea.setOnClickListener {
            var action = TipoComidaFragmentDirections.actionTipoComidaFragmentToCartaFragment(R.drawable.comida4)
            findNavController().navigate(action)
        }

        binding.btnMexicana.setOnClickListener{
            val action = TipoComidaFragmentDirections.actionTipoComidaFragmentToCartaMexicanaFragment()
            findNavController().navigate(action)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}