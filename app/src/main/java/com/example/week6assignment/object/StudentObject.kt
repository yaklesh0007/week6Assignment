package com.example.week6assignment.`object`

import com.example.week6assignment.Models.Student

object StudentObject {

    var lstStudent = arrayListOf<Student>()

    fun getStudent(): ArrayList<Student> {
        return lstStudent;
    }

    fun setStudent(s: Student) {
        lstStudent.add(s);
    }
}