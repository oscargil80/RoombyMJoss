package com.oscargil80.ejemploroommvvmjoss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.ejemploroommvvmjoss.adaptadores.PersonalAdapter
import com.oscargil80.ejemploroommvvmjoss.config.Constantes
import com.oscargil80.ejemploroommvvmjoss.databinding.ActivityMainBinding
import com.oscargil80.ejemploroommvvmjoss.ui.FormularioActivity
import com.oscargil80.ejemploroommvvmjoss.viewModel.MainViewModel
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO ENLAZAR EL MODELO CON EL LIVE DATA
        viewModel= ViewModelProvider(this).get()
        viewModel.iniciar()

        binding.miRecycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.personalList.observe(this, Observer {
            binding.miRecycler.adapter = PersonalAdapter(it)
        })

        binding.btnAbrirFormulario.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            intent.putExtra(Constantes.OPERACION_KEY, Constantes.OPERACION_INSERTAR)
            startActivity(intent)
        }
    }


}