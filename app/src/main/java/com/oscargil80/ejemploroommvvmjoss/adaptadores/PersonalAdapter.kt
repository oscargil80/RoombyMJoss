package com.oscargil80.ejemploroommvvmjoss.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.ejemploroommvvmjoss.R
import com.oscargil80.ejemploroommvvmjoss.models.Personal


class PersonalAdapter(
    var PersonalList: List<Personal>,
) : RecyclerView.Adapter<PersonalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonalViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        val item = PersonalList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = PersonalList.size
}
