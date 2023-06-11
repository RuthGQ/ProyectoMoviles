package com.example.proyectomovil.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectomovil.entity.UsuarioEntity
import com.example.proyectomovil.repository.UsuarioRepository
import com.example.proyectomovil.room.Resultado
import com.example.proyectomovil.ui.view.fragment.LoginResult
import kotlinx.coroutines.launch

//@HiltViewModel
class UsuarioViewModel(private var repository: UsuarioRepository):ViewModel() {

    val usuarios: LiveData<List<UsuarioEntity>> = repository.listaUsuario.asLiveData()

    private var _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun agregar(usuario: UsuarioEntity){
        viewModelScope.launch {
            repository.agregar(usuario)
        }
    }

    fun actualizar(usuario: UsuarioEntity){
        viewModelScope.launch {
            repository.actualizar(usuario)
        }
    }

    fun eliminar(usuario: UsuarioEntity){
        viewModelScope.launch {
            repository.eliminar(usuario)
        }
    }

    fun login(user: String, clave: String){
        viewModelScope.launch {
            val resultado = repository.obtenerUsuarioPorUserYClave(user, clave)

            if (resultado is Resultado.Success){
                Log.i("rspta", resultado.data.toString())
                _loginResult.value = LoginResult(success = resultado.data)
            }else{
                _loginResult.value = LoginResult(error = 0)
            }

        }
    }
}