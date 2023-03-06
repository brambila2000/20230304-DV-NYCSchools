package com.example.a20230304_dv_nycschools.util

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20230304_dv_nycschools.data.data.model.SchoolModel
import com.example.a20230304_dv_nycschools.databinding.JprecyclerViewBinding


//RecyclerView Component
class JPRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var binding: JprecyclerViewBinding =
        JprecyclerViewBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

    fun bindDataToTable(
        list: List<SchoolModel>,
        destination: Int
    ){
        val adapter = CustomAdapter(
            list,
            { view: View, text: String -> navigateToDetailsFragment(view, text, destination) }
        )

        val recyclerView = binding.recyclerview
        val linearLayoutManager: LinearLayoutManager
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    fun navigateToDetailsFragment(view: View, str: String, destination: Int){
        val bundle = Bundle()
        bundle.putString("school", str)
        view.findNavController().navigate(destination, bundle)
    }

}