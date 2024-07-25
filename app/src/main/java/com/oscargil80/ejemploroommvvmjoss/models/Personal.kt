package com.oscargil80.ejemploroommvvmjoss.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal(
    @PrimaryKey(autoGenerate = true)
    val idEmpleado:Long,
    val nombre:String,
    val apellido:String,
    val email:String,
    val telefono:String,
    val edad:Int
)
