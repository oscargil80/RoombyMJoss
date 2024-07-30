package com.oscargil80.ejemploroommvvmjoss.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscargil80.ejemploroommvvmjoss.config.PersonalApp.Companion.db
import com.oscargil80.ejemploroommvvmjoss.models.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val personalList = MutableLiveData<List<Personal>>()
    var parametroBusqueda = MutableLiveData<String>()

    fun iniciar() {
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO) {
                       db.personalDao().getAll()
            }
        }
    }

    fun buscarPersonal() {
        viewModelScope.launch {
            personalList.value = withContext(Dispatchers.IO) {
                db.personalDao().getByName(parametroBusqueda.value!!)
            }
        }
    }
}