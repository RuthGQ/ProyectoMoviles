package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding : FragmentMenuBinding? = null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresarPrincipal.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToPrincipalFragment()
            findNavController().navigate(action)
        }
        binding.btnMetodoPago.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToMetodoFragment()
            findNavController().navigate(action)
        }
    }

}