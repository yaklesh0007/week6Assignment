package com.example.week6assignment.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week6assignment.Models.Student
import com.example.week6assignment.R
import com.example.week6assignment.`object`.StudentObject
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.student_layout.view.*

class StudentAdapter(
    val lstStudents:ArrayList<Student>,
    val context:Context
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val imgProfile:ImageView
        val tvName:TextView
        val tvage:TextView
        val tvAddress:TextView
        val tvgender:TextView
        val imageView:ImageView

        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvage=view.findViewById(R.id.tvage)
            tvgender=view.findViewById(R.id.tvgender)
            imageView=view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lstStudents.size;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var gender:Int= 0;
        val student=lstStudents[position]
        holder.tvName.text=student.StudentName

        holder.tvage.text=student.StudentAge.toString()
        holder.tvAddress.text=student.StudentAddress
        holder.tvgender.text=student.StudentGender

        holder.imgProfile.setOnClickListener {
            Toast.makeText(context,"This is: ${holder.tvName.toString()} ",Toast.LENGTH_LONG).show()
        }
        if(student.StudentGender=="Male"){
            gender = R.drawable.male
        }else if(student.StudentGender=="Female"){
            gender = R.drawable.femele
        }else if(student.StudentGender=="Other"){
            gender = R.drawable.noimg
        }
        holder.imgProfile.setImageResource(gender)

        holder.imageView.setOnClickListener {
            lstStudents.removeAt(position)
            notifyDataSetChanged()
        }



    }
}