package com.oscargil80.ejemploroommvvmjoss.adaptadores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.ejemploroommvvmjoss.databinding.ItemListBinding
import com.oscargil80.ejemploroommvvmjoss.models.Personal

class PersonalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemListBinding.bind(view)

    fun render(Personal: Personal) {
        binding.tvNombre.text = "${Personal.nombre} ${Personal.apellido}"
        binding.tvEmail.text = Personal.email
        binding.tvTelefono.text = Personal.telefono
        binding.tvEdad.text = Personal.edad.toString()

        //todo evento on clic


        /*XXXXXXXXXX.text = Personal.XXXXXXXXXX.text = Personal.binding.ibDelete.setOnClickListener {
            onItemSeleted(adapterPosition)
        }*/
    }
}