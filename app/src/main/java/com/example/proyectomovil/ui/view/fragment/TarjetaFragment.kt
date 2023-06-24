package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentComidaBinding
import com.example.proyectomovil.databinding.FragmentTarjetaBinding

class TarjetaFragment : Fragment() {

    private var _binding : FragmentTarjetaBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAgregartarjeta.setOnClickListener {
            val action = TarjetaFragmentDirections.actionTarjetaFragmentToAgregarTarjetaFragment()
            findNavController().navigate(action)
        }
    }

}