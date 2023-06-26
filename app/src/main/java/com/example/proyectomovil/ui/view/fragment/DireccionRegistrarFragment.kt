package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentDireccionRegistrarBinding
import com.example.proyectomovil.entity.UsuarioEntity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegistrar.setOnClickListener {

            binding.txtDistrito.error=null
            binding.txtProvincia.error=null
            binding.txtCodigoPostal.error=null
            binding.txtDireccion.error=null

            /*DISTRITO*/
            val distrito = binding.txtDistrito.editText?.text.toString()
            val distritoValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()

            /*PROVINCIA*/
            val provincia = binding.txtProvincia.editText?.text.toString()
            val provinciaValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()

            /*CODIGO POSTAL*/
            val codigoPostal = binding.txtCodigoPostal.editText?.text.toString()
            val codigoPostalValidar = "[0-9]{4}".toRegex()

            /*DIRECCION*/
            val direccion = binding.txtDireccion.editText?.text.toString()
            val direccionValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()

            if (distrito.isEmpty()){
                binding.txtDistrito.error="Campo Requerido"
                return@setOnClickListener
            }else if (!distritoValidar.matches(distrito)){
                binding.txtDistrito.error="No cumple con los caracteres"
                return@setOnClickListener
            } else if (provincia.isEmpty()){
                binding.txtProvincia.error="Campo Requerido"
                return@setOnClickListener
            } else if(!provinciaValidar.matches(provincia)){
                binding.txtProvincia.error="No cumple con los caracteres"
                return@setOnClickListener
            } else if (codigoPostal.isEmpty()){
                binding.txtCodigoPostal.error="Campo Requerido"
                return@setOnClickListener
            } else if (!codigoPostalValidar.matches(codigoPostal)){
                binding.txtCodigoPostal.error="No cumple con los caracteres"
                return@setOnClickListener
            } else if (direccion.isEmpty()){
                binding.txtDireccion.error="Campo Requerido"
                return@setOnClickListener
            } else if (!direccionValidar.matches(direccion)){
                binding.txtDireccion.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            MaterialAlertDialogBuilder(this.requireContext(), R.style.MaterialAlertDialog__Center)
                .setTitle("-------------EXITO-------------")
                .setMessage("Dirección Registrada")
                .show()

            val action = DireccionRegistrarFragmentDirections.actionDireccionRegistrarFragmentToDireccionFragment()
            findNavController().navigate(action)

        }
    }

}