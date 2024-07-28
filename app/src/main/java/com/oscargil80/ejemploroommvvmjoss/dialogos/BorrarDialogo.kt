package com.oscargil80.ejemploroommvvmjoss.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class BorrarDialogo (var borrarListener:BorrarListener): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Borrar Personal")
                .setPositiveButton("Si, Borrar") { dialog, id ->
                    borrarListener.borrarPersona()
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    dialog.cancel()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface BorrarListener{
        fun borrarPersona()
    }
}

