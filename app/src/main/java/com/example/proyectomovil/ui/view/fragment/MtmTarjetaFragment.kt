package com.example.proyectomovil.ui.view.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyectomovil.ProjectApplication
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentAgregarTarjetaBinding
import com.example.proyectomovil.databinding.FragmentMtmTarjetaBinding
import com.example.proyectomovil.entity.TarjetaEntity
import com.example.proyectomovil.ui.viewmodel.TarjetaViewModel
import com.example.proyectomovil.ui.viewmodel.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MtmTarjetaFragment : Fragment() {

    private var _binding : FragmentMtmTarjetaBinding? = null
    private val binding get() = _binding!!

    private val tarjetasViewModel by viewModels<TarjetaViewModel> {
        val app = requireActivity().application as ProjectApplication
        ViewModelFactory(app.tarjetaDBRepository)
    }

    private val args by navArgs<MtmTarjetaFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMtmTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    lateinit var contexto: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tarjetasViewModel.obtenerTarjeta(args.iduser).observe(viewLifecycleOwner){
            if (it != null){
                binding.txtPropietario.editText?.text = Editable.Factory.getInstance().newEditable(it.propietario)
                binding.txtNumero.editText?.text = Editable.Factory.getInstance().newEditable(it.numero.toString())
                binding.txtCvv.editText?.text = Editable.Factory.getInstance().newEditable(it.cvv.toString())
                binding.txtFecha.editText?.text = Editable.Factory.getInstance().newEditable(it.fecha)
            }
        }

        binding.btnActualizar.setOnClickListener {
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
                .setMessage("Tarjeta Actualizada")
                .show()

            var tarjetaEntity = TarjetaEntity(id = args.iduser.toInt(), propietario = nombre, numero = numero.toLong(), cvv = cvv.toInt(), fecha = fecha)

            Log.i("act", tarjetaEntity.toString())
            tarjetasViewModel.actualizar(tarjetaEntity)
        }

        binding.btnEliminar.setOnClickListener {
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

            var tarjetaEntity = TarjetaEntity(id = args.iduser.toInt() ,propietario = nombre, numero = numero.toLong(), cvv = cvv.toInt(), fecha = fecha)

            tarjetasViewModel.eliminar(tarjetaEntity)
            MaterialAlertDialogBuilder(contexto)
                .setTitle("Exitoso")
                .setMessage("Tarjeta Eliminada")
                .show()

            findNavController().navigate(R.id.action_mtmTarjetaFragment_to_tarjetaFragment)
        }


    }

}