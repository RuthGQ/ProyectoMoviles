package com.example.proyectomovil.ui.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.proyectomovil.ProjectApplication
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentAgregarTarjetaBinding
import com.example.proyectomovil.databinding.FragmentTarjetaBinding
import com.example.proyectomovil.entity.TarjetaEntity
import com.example.proyectomovil.ui.viewmodel.TarjetaViewModel
import com.example.proyectomovil.ui.viewmodel.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AgregarTarjetaFragment : Fragment() {

    private var _binding : FragmentAgregarTarjetaBinding? = null
    private val binding get() = _binding!!

    val tarjetaViewModel by viewModels<TarjetaViewModel> {
        val app = requireActivity().application as ProjectApplication
        ViewModelFactory(app.tarjetaDBRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgregarTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    lateinit var contexto:Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tarjetaViewModel.tarjetas.observe(viewLifecycleOwner){
            Log.i("Mensaje", "Otra vez se actualiza")
        }

        binding.btnAgregar.setOnClickListener {
            Log.i("AG", "Presiono")




            val nombre =binding.txtPropietario.editText?.text.toString()
            val nombreValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()
            if (nombre.isEmpty()){
                binding.txtPropietario.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!nombreValidar.matches(nombre)){
                binding.txtPropietario.error="No cumple con los caracteres"
                return@setOnClickListener
            }
            binding.txtPropietario.error = null

            val numero = binding.txtNumero.editText?.text.toString()
            val numeroValidar = "[0-9]{16}".toRegex()
            if (numero.isEmpty()){
                binding.txtNumero.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!numeroValidar.matches(numero)){
                binding.txtNumero.error="No cumple con los caracteres"
                return@setOnClickListener
            }
            binding.txtNumero.error = null

            val cvv = binding.txtCvv.editText?.text.toString()
            val cvvValidar = "[0-9]{5}".toRegex()
            if (cvv.isEmpty()){
                binding.txtCvv.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!cvvValidar.matches(cvv)){
                binding.txtCvv.error="No cumple con los caracteres"
                return@setOnClickListener
            }
            binding.txtCvv.error = null

            val fecha = binding.txtFecha.editText?.text.toString()
            binding.txtFecha.error = null

            MaterialAlertDialogBuilder(contexto)
                .setTitle("Exitoso")
                .setMessage("Tarjeta agregada")
                .show()

            Log.i("R", " $numero -> $nombre -> $cvv -> $fecha" )

            val tarjetaEntity = TarjetaEntity(numero = numero.toLong(), propietario = nombre, cvv = cvv.toInt(), fecha = fecha)

            tarjetaViewModel.insertar(tarjetaEntity)
            clearFields()
        }
    }

    fun clearFields(){
        binding.txtPropietario.editText?.text?.clear()
        binding.txtPropietario.editText?.clearFocus()
        binding.txtNumero.editText?.text?.clear()
        binding.txtNumero.editText?.clearFocus()
        binding.txtCvv.editText?.text?.clear()
        binding.txtCvv.editText?.clearFocus()
        binding.txtFecha.editText?.text?.clear()
        binding.txtFecha.editText?.clearFocus()
    }

}