package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentRegisterBinding
import com.example.proyectomovil.entity.UsuarioEntity
import com.example.proyectomovil.ui.ActivityViewModel
import com.example.proyectomovil.ui.viewmodel.UsuarioViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var _binding : FragmentRegisterBinding? = null
    private val binding get()= _binding!!

    private val usuarioViewModel by viewModels<UsuarioViewModel>()
    private val activityViewModel by viewModels<ActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      // Log.i("TAGs", prefs.stringPref.toString())
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegistrarseCuenta.setOnClickListener {

            print("Entro aqui")

            binding.txtNombre.error=null
            binding.txtApellido.error=null
            binding.txtCorreo.error=null
            binding.txtTelefono.error=null
            binding.txtUser.error=null
            binding.txtContra.error=null

            val nombre =binding.txtNombre.editText?.text.toString()
            val nombreValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()
            if (nombre.isEmpty()){
                binding.txtNombre.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!nombreValidar.matches(nombre)){
                binding.txtNombre.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            val apellido = binding.txtApellido.editText?.text.toString()
            val apellidoValidar = "[A-Za-z\\-_\\sÑñ]{1,70}".toRegex()
            if (apellido.isEmpty()){
                binding.txtApellido.error="Campo Requerido"
                return@setOnClickListener
            }
            if(!apellidoValidar.matches(apellido)){
                binding.txtApellido.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            val correo = binding.txtCorreo.editText?.text.toString()
            val correoValidar = "[a-z\\d]+@[a-z]+\\.[a-z]{2,3}".toRegex()
            if (correo.isEmpty()){
                binding.txtCorreo.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!correoValidar.matches(correo)){
                binding.txtCorreo.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            val telefono = binding.txtTelefono.editText?.text.toString()
            val telefonoValidar = "[0-9]{9}".toRegex()
            if (telefono.isEmpty()){
                binding.txtTelefono.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!telefonoValidar.matches(telefono)){
                binding.txtTelefono.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            val user = binding.txtUser.editText?.text.toString()
            val userValidar = "[A-Za-z\\d\\-_\\sÑñ]{1,70}".toRegex()
            if(user.isEmpty()){
                binding.txtUser.error="Campo Requerido"
                return@setOnClickListener
            }
            if(!userValidar.matches(user)){
                binding.txtUser.error="No cumple con los caracteres"
                return@setOnClickListener
            }

            val clave = binding.txtContra.editText?.text.toString()
            val claveValidar = "[A-Za-z\\d\\-_\\sÑñ]{1,70}".toRegex()
            if (clave.isEmpty()){
                binding.txtContra.error="Campo Requerido"
                return@setOnClickListener
            }
            if (!claveValidar.matches(clave)){
                binding.txtContra.error="No cumple con los caracteres"
                return@setOnClickListener
            }
            MaterialAlertDialogBuilder(this.requireContext(), R.style.MaterialAlertDialog__Center)
                .setTitle("-------------EXITO-------------")
                .setMessage("Usuario Registrado")
                .show()

            print("ahora squiii")

            val usuario = UsuarioEntity(id, nombre, apellido, correo, telefono, user = user, clave = clave)

            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

            print(usuario)

        }



        binding.btnIngresarRegister.setOnClickListener{
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}