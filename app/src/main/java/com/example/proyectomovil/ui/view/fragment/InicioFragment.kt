package com.example.proyectomovil.ui.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.ActivityMainBinding
import com.example.proyectomovil.databinding.FragmentInicioBinding
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class InicioFragment : Fragment() {

    private var _binding : FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding =FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnIngresar.setOnClickListener {
            val action = InicioFragmentDirections.actionInicioFragmentToLoginFragment()
            findNavController().navigate(action)
        }

        binding.btnRegistrarse.setOnClickListener {
            val action = InicioFragmentDirections.actionInicioFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}