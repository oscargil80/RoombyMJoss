package com.oscargil80.ejemploroommvvmjoss.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.oscargil80.ejemploroommvvmjoss.MainActivity
import com.oscargil80.ejemploroommvvmjoss.R
import com.oscargil80.ejemploroommvvmjoss.config.Constantes
import com.oscargil80.ejemploroommvvmjoss.databinding.ActivityFormularioBinding
import com.oscargil80.ejemploroommvvmjoss.databinding.ActivityMainBinding
import com.oscargil80.ejemploroommvvmjoss.viewModel.FormularioViewModel

class FormularioActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormularioBinding
    lateinit var viewModel: FormularioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!

        binding.modelo = viewModel
        binding.lifecycleOwner = this

        viewModel.operacionExitosa.observe(this, Observer {
            if (it) {
                mostrarMensaje("Operacion Exitosa")
                irAlInicio()
            } else {
                mostrarMensaje("Operacion Exitosa")
            }
        })

        if(viewModel.operacion.equals(Constantes.OPERACION_EDITAR)){
            viewModel.id.value = intent.getLongExtra(Constantes.ID_PERSONAL_KEY, 0)
            viewModel.cargarDatos()
            binding.linearEditar.visibility = View.VISIBLE
            binding.btnGuardar.visibility = View.GONE
        }else{
            binding.linearEditar.visibility = View.GONE
            binding.btnGuardar.visibility = View.VISIBLE

        }

    }

    private fun irAlInicio() {
       val intent = Intent(applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun mostrarMensaje(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}