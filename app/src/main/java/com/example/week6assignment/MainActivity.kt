package com.example.week6assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtusername:EditText
    private lateinit var edtpassword:EditText
    private lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtusername=findViewById(R.id.edtusername)
        edtpassword=findViewById(R.id.edtpassword)
        btnlogin=findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            if (edtusername.text.toString()=="softwarica" && edtpassword.text.toString()=="coventry")
            {
                val intent=Intent(this@MainActivity,Dashboard::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"invalid login access",Toast.LENGTH_LONG).show()
            }
        }
    }
}