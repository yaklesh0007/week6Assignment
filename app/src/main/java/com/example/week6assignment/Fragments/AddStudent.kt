package com.example.week6assignment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isEmpty
import com.example.week6assignment.Models.Student
import com.example.week6assignment.R
import com.example.week6assignment.`object`.StudentObject


class AddStudent : Fragment() {

    private lateinit var edtfullname: EditText
    private lateinit var edtage: EditText
    private lateinit var edtaddress: EditText
    private lateinit var btnsave: Button
    private lateinit var rdogroup: RadioGroup
    private lateinit var rdomale: RadioButton
    private lateinit var rdofemale: RadioButton
    private lateinit var rdoothers: RadioButton
    var gender: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)
        edtfullname = view.findViewById(R.id.edtfullname)
        edtaddress = view.findViewById(R.id.edtaddress)
        edtage = view.findViewById(R.id.edtage)
        btnsave = view.findViewById(R.id.btnsave)
        rdogroup = view.findViewById(R.id.rdogroup)
        rdomale = view.findViewById(R.id.rdomale)
        rdofemale = view.findViewById(R.id.rdofemale)
        rdoothers = view.findViewById(R.id.rdoothers)
        var i: Int = 1;
        btnsave.setOnClickListener {
            if (edtfullname.text.isEmpty()) {
                edtfullname.error = "Name should not be empty !"
            }
            else if (edtage.text.isEmpty()) {
                edtage.error = "Age should not be empty !"
            }
             else if (edtaddress.text.isEmpty()) {
                edtaddress.error = "Address Should not be empty !"
            }
            else if(rdomale.isChecked && rdofemale.isChecked && rdoothers.isChecked ){
                Toast.makeText(context,"Gender must be specified",Toast.LENGTH_LONG).show()
            }

            else{

                var name = edtfullname.text.toString()
                var age = edtage.text.toString().toInt()
                var address = edtaddress.text.toString()

                StudentObject.setStudent(Student(name,age,gender,address));

                Toast.makeText(context, "Data saved Successfully!!", Toast.LENGTH_LONG).show()
                reset();

            }


        }
        rdogroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rdomale->{
                        gender="Male"
                    }
                    R.id.rdofemale->{
                        gender="Female"
                    }
                    R.id.rdoothers->{
                        gender="Other"
                    }
                }
            }

        })

        return view
    }



private fun reset(){
   edtfullname.setText("")
    edtage.setText("")
    edtaddress.setText("")

}

}