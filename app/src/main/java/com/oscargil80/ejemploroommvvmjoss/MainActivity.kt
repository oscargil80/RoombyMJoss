package com.oscargil80.ejemploroommvvmjoss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.oscargil80.ejemploroommvvmjoss.databinding.ActivityMainBinding
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
    }


}