package com.oscargil80.ejemploroommvvmjoss.viewModel

import android.provider.ContactsContract.CommonDataKinds.Contactables
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscargil80.ejemploroommvvmjoss.config.Constantes
import com.oscargil80.ejemploroommvvmjoss.config.PersonalApp.Companion.db
import com.oscargil80.ejemploroommvvmjoss.models.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormularioViewModel : ViewModel() {
    var id = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var apellidos = MutableLiveData<String>()
    var telefono = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var edad = MutableLiveData<Int>()
    var operacion = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        edad.value = 18
    }

    fun guardarUsuario() {
        var mPersonal = Personal(
            0,
            nombre.value!!,
            apellidos.value!!,
            email.value!!,
            telefono.value!!,
            edad.value!!
        )
        when (operacion) {
            Constantes.OPERACION_INSERTAR -> {
                viewModelScope.launch {
                    val result = withContext(Dispatchers.IO) {
                        db.personalDao().insert(
                            arrayListOf<Personal>(
                                mPersonal
                            )
                        )
                    }
                    operacionExitosa.value = result.isNotEmpty()
                }

            }
            Constantes.OPERACION_EDITAR-> {
            }
        }
    }
}


