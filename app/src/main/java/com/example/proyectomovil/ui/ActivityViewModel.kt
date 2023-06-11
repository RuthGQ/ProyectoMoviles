package com.example.proyectomovil.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectomovil.prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
class ActivityViewModel @Inject constructor() : ViewModel() {

    private val _onSession = MutableLiveData<Boolean>()
    val onSession: LiveData<Boolean> = _onSession

    fun setData(id: Int){
        prefs.stringPref = id.toString()
    }

    fun clearData(){
        prefs.stringPref = null
    }

    fun getStatus(){
        _onSession.value = !(prefs.stringPref == null || prefs.stringPref!!.isEmpty())
    }
}