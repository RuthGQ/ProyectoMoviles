package com.example.proyectomovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectomovil.databinding.FragmentLoginBinding
import com.example.proyectomovil.ui.ActivityViewModel
import com.example.proyectomovil.ui.viewmodel.UsuarioViewModel

//@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val usuarioViewModel by viewModels<UsuarioViewModel>()
    private val activityViewModel by viewModels<ActivityViewModel>()

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    //@SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val username = binding.txtUsuario
        val password = binding.txtClave
        val login = binding.btnIngresarLogin

        login.setOnClickListener {
            /*usuarioViewModel.login(
                username.editText?.text.toString(),
                password.editText?.text.toString()
            )*/
            val action = LoginFragmentDirections.actionLoginFragmentToPrincipalFragment()
            findNavController().navigate(action)
        }
        /*
        usuarioViewModel.loginResult.observe(viewLifecycleOwner){
        val loginResult = it ?:return@observe

            if (loginResult.error != null){
                return@observe
            }
            if (loginResult.success != null){
                activityViewModel.setData(loginResult.success.id)
                findNavController().navigate(R.id.action_loginFragment_to_principalFragment)
            }


        }*/

        /*
        activityViewModel.getStatus()
        activityViewModel.onSession.observe(viewLifecycleOwner){
            usuarioViewModel.usuarios.observe(viewLifecycleOwner){usuario->
                if (usuario.isNotEmpty()){
                    if (it){
                        findNavController().navigate(R.id.action_loginFragment_to_principalFragment)
                    }
                }else{
                    activityViewModel.clearData()
                }


            }
        }*/

        binding.btnRegistrarLogin.setOnClickListener {

            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }

    }
}