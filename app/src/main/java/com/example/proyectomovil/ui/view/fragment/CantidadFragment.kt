package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentCantidadBinding


class CantidadFragment : Fragment() {

    private var _binding: FragmentCantidadBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCantidadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresarPrincipal2.setOnClickListener {
            val action = CantidadFragmentDirections.actionCantidadFragmentToPrincipalFragment()
            findNavController().navigate(action)
        }

        binding.btnContinuar.setOnClickListener {
            val action = CantidadFragmentDirections.actionCantidadFragmentToComidaFragment()
            findNavController().navigate(action)
        }

    }
}