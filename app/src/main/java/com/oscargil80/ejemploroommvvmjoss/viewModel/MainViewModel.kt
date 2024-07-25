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
        /*        db.personalDao().insert(
                    arrayListOf<Personal>(
                        Personal(
                            0,
                            "Oscar",
                            "Medina Lugo",
                            "oscargil80@gmail.com",
                            "04146456926",
                            44
                        ),
                        Personal(
                            0,
                            "Ligia",
                            "Medina L",
                            "lalininvirginia@gmail.com",
                            "04246597218",
                            48
                        )
                    )
                )*/

                db.personalDao().getAll()
            }

            for (personal in personalList.value!!){
                Log.d("Mensaje", "id ${personal.idEmpleado}, nombre ${personal.nombre}")

            }
        }
    }
}