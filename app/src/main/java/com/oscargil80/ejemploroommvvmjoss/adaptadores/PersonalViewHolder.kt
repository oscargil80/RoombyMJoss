package com.oscargil80.ejemploroommvvmjoss.adaptadores

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.ejemploroommvvmjoss.config.Constantes
import com.oscargil80.ejemploroommvvmjoss.databinding.ItemListBinding
import com.oscargil80.ejemploroommvvmjoss.models.Personal
import com.oscargil80.ejemploroommvvmjoss.ui.FormularioActivity

class PersonalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ItemListBinding.bind(view)
     val context = view.context
    fun render(Personal: Personal) {
        binding.tvNombre.text = "${Personal.nombre} ${Personal.apellido}"
        binding.tvEmail.text = Personal.email
        binding.tvTelefono.text = Personal.telefono
        binding.tvEdad.text = Personal.edad.toString()

        //todo evento on clic
        binding.root.setOnClickListener {
            val intent = Intent(context, FormularioActivity::class.java)
            intent.putExtra(Constantes.OPERACION_KEY, Constantes.OPERACION_EDITAR)
            intent.putExtra(Constantes.ID_PERSONAL_KEY, Personal.idEmpleado)
            context.startActivity(intent)
        }


        /*XXXXXXXXXX.text = Personal.XXXXXXXXXX.text = Personal.binding.ibDelete.setOnClickListener {
            onItemSeleted(adapterPosition)
        }*/
    }
}