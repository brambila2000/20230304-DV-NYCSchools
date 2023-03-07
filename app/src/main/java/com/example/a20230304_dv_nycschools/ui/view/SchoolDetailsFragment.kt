package com.example.a20230304_dv_nycschools.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.a20230304_dv_nycschools.R
import com.example.a20230304_dv_nycschools.data.data.model.SchoolDataModel
import com.example.a20230304_dv_nycschools.databinding.FragmentSchoolDetailsBinding
import com.example.a20230304_dv_nycschools.ui.viewmodel.NYCSchoolsViewModel


class SchoolDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSchoolDetailsBinding
    private val nycSchoolsViewModel: NYCSchoolsViewModel by viewModels()
    private lateinit var schoolScoresList: List<SchoolDataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_school_details, container, false)
        binding = FragmentSchoolDetailsBinding.bind(view)

        val schoolSelected = arguments?.getString("school")

        nycSchoolsViewModel.getSchoolsData()

        nycSchoolsViewModel.schoolDataModel.observe(viewLifecycleOwner, Observer {
            schoolScoresList = it
            //Some school names do not match in the two end points given, therefore it wont find the
            //the information, while some will match. This is a just a bare bones app to improve on
            binding.school.text = schoolSelected.toString()
            for (school in schoolScoresList) {
                if (school.name.contains(schoolSelected.toString(), true)) {
                    binding.takers.text = "Takers: ${school.takers}"
                    binding.math.text = "Math Score: ${school.math}"
                    binding.reading.text = "Reading Score: ${school.reading}"
                    binding.writing.text = "Writing Score: ${school.writing}"
                    println("${school.name} = ${schoolSelected.toString()}")
                    break
                }
            }

        })

        return view
    }
}