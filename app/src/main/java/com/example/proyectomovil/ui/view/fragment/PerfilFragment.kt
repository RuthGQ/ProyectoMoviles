package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.ProjectApplication
import com.example.proyectomovil.R
import com.example.proyectomovil.databinding.FragmentPerfilBinding
import com.example.proyectomovil.entity.UsuarioEntity
import com.example.proyectomovil.prefs
import com.example.proyectomovil.ui.ActivityViewModel
import com.example.proyectomovil.ui.viewmodel.UsuarioViewModel
import com.example.proyectomovil.ui.viewmodel.ViewModelFactory

class PerfilFragment : Fragment() {
    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private val usuarioViewModel by viewModels<UsuarioViewModel> {
        val app = requireActivity().application as ProjectApplication
        ViewModelFactory(usuarioRepository = app.usuarioDBRepository)
    }

    private val activityViewModel by viewModels<ActivityViewModel> {
        val app = requireActivity().application as ProjectApplication
        ViewModelFactory()
    }

    lateinit var usuario: UsuarioEntity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuarioViewModel.obtenerUsuarioXid(prefs.stringPref.toString())

        usuarioViewModel.usuarioXid.observe(viewLifecycleOwner){
            binding.txtNombreApellido.text = it.nombre+it.apellido
            binding.txtNombre.text = it.nombre
            binding.txtApellido.text = it.apellido
            binding.txtCorreo.text = it.correo
            binding.txtTelefono.text = it.telefono
            binding.txtUser.text = it.user
            binding.txtClave.text = it.clave


        }

        binding.btnCerrar.setOnClickListener {
            activityViewModel.clearData()
            activityViewModel.getStatus()
        }

        activityViewModel.onSession.observe(viewLifecycleOwner){
            if (!it) {
                findNavController().navigate(R.id.action_perfilFragment_to_inicioFragment)
            }
        }




    }


}