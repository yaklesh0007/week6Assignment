package com.example.week6assignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment.Adapters.StudentAdapter
import com.example.week6assignment.Models.Student
import com.example.week6assignment.R
import com.example.week6assignment.`object`.StudentObject


class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)


        val adapter = StudentAdapter(StudentObject.getStudent(), context!!)
        loadStudentdata()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return view
    }
    fun loadStudentdata(){
        if (StudentObject.getStudent().isEmpty()){
            StudentObject.setStudent(Student("aklesh",21,"Male","Bhw"))
        }
        else{
            StudentObject.getStudent()
        }
    }


}