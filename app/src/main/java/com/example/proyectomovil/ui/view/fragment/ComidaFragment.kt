package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentComidaBinding


class ComidaFragment : Fragment() {

    private var _binding: FragmentComidaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentComidaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegresar.setOnClickListener {
            var action = ComidaFragmentDirections.actionComidaFragmentToCantidadFragment()
            findNavController().navigate(action)
        }

        binding.btnAlmuerzo.setOnClickListener {
            var action = ComidaFragmentDirections.actionComidaFragmentToTipoComidaFragment()
            findNavController().navigate(action)
        }
    }
}