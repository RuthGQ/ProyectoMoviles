package com.example.proyectomovil.ui.view.fragment

import com.example.proyectomovil.entity.UsuarioEntity

data class LoginResult (
    val success: UsuarioEntity? = null,
    val error: Int? = null
        )