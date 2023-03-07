package com.example.a20230304_dv_nycschools.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.a20230304_dv_nycschools.R
import com.example.a20230304_dv_nycschools.databinding.FragmentNYCSchoolsBinding
import com.example.a20230304_dv_nycschools.ui.viewmodel.NYCSchoolsViewModel

class NYCSchoolsFragment : Fragment() {

    private lateinit var binding: FragmentNYCSchoolsBinding

    private val nycSchoolsViewModel: NYCSchoolsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_n_y_c_schools, container, false)
        binding = FragmentNYCSchoolsBinding.bind(view)

        nycSchoolsViewModel.getSchools()

        nycSchoolsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

        nycSchoolsViewModel.schoolModelList.observe(viewLifecycleOwner, Observer { currentList ->
            val schoolsList = currentList

            binding.jprecyclerview.bindDataToTable(
                schoolsList,
                R.id.action_NYCSchoolsFragment_to_schoolDetailsFragment
            )
        })

        return view
    }
}