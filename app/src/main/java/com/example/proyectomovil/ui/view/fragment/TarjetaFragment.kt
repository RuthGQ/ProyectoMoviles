package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.ProjectApplication
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentComidaBinding
import com.example.proyectomovil.databinding.FragmentTarjetaBinding
import com.example.proyectomovil.ui.view.adapter.TarjetaAdapter
import com.example.proyectomovil.ui.viewmodel.TarjetaViewModel
import com.example.proyectomovil.ui.viewmodel.ViewModelFactory

class TarjetaFragment : Fragment() {

    private var _binding : FragmentTarjetaBinding? = null
    private val binding get()= _binding!!

    val tarjetaViewModel by viewModels<TarjetaViewModel> {
        val app = requireActivity().application as ProjectApplication
        ViewModelFactory(app.tarjetaDBRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tarjetasAdapter = TarjetaAdapter{
         val action = TarjetaFragmentDirections.actionTarjetaFragmentToMtmTarjetaFragment(it.id.toString())
         findNavController().navigate(action)
        }

        binding.rvTarjetas.adapter = tarjetasAdapter

        tarjetaViewModel.tarjetas.observe(viewLifecycleOwner){
            Log.i("Mensaje", "Otra vez se actualiza")
            tarjetasAdapter.clean()
            tarjetasAdapter.cargarLista(it)
        }

        binding.fabAgregartarjeta.setOnClickListener {
            val action = TarjetaFragmentDirections.actionTarjetaFragmentToAgregarTarjetaFragment()
            findNavController().navigate(action)
        }
    }

}