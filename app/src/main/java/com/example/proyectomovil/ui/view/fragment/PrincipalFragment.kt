package com.example.proyectomovil.ui.view.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentLoginBinding
import com.example.proyectomovil.databinding.FragmentPrincipalBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class PrincipalFragment : Fragment() {

    private var _binding: FragmentPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMenu.setOnClickListener{
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        binding.btnCarrito.setOnClickListener {
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToCarritoFragment()
            findNavController().navigate(action)
        }

        binding.btnCena.setOnClickListener {
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToCantidadFragment()
            findNavController().navigate(action)
        }

        binding.btnCumple.setOnClickListener{
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToCantidadFragment()
            findNavController().navigate(action)
        }
        binding.btnGraduacion.setOnClickListener {
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToCantidadFragment()
            findNavController().navigate(action)
        }
        binding.btnOtro.setOnClickListener {
            val action = PrincipalFragmentDirections.actionPrincipalFragmentToCantidadFragment()
            findNavController().navigate(action)
        }



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}
