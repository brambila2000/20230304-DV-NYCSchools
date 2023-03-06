package com.example.a20230304_dv_nycschools.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a20230304_dv_nycschools.R
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel

class CustomAdapter(
    private val dataSet: List<SchoolModel>,
    private val listener: (View, String) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.view)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val school = dataSet[position]
        viewHolder.textView.text = school.name
        viewHolder.itemView.setOnClickListener {
            listener(it, school.name)
        }
    }

    override fun getItemCount() = dataSet.size
}
