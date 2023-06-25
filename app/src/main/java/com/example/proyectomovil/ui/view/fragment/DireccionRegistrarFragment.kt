package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyectomovil.databinding.FragmentDireccionRegistrarBinding

class DireccionRegistrarFragment : Fragment (){

    private var _binding : FragmentDireccionRegistrarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDireccionRegistrarBinding.inflate(inflater, container, false)
        return binding.root
    }


}