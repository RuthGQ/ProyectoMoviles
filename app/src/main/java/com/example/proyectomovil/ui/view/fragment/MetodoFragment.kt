package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentMetodoBinding

class MetodoFragment : Fragment() {

    private var _binding : FragmentMetodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMetodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresarMenu.setOnClickListener {
            val action = MetodoFragmentDirections.actionMetodoFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        binding.btnTarjeta.setOnClickListener {
            val action = MetodoFragmentDirections.actionMetodoFragmentToTarjetaFragment()
            findNavController().navigate(action)
        }
    }

}