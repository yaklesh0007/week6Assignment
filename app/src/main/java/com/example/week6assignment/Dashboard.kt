package com.example.week6assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.week6assignment.Adapters.ViewPagerAdapter
import com.example.week6assignment.Fragments.AboutUs
import com.example.week6assignment.Fragments.AddStudent
import com.example.week6assignment.Fragments.HomeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Dashboard : AppCompatActivity() {
    private lateinit var viewpager:ViewPager2
    private lateinit var tablayout:TabLayout
    private lateinit var lsttitle:ArrayList<String>
    private lateinit var lstfragments:ArrayList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        viewpager=findViewById(R.id.viewpager)
        tablayout=findViewById(R.id.tablayout)

        populatelist()
        val adapter=ViewPagerAdapter(lstfragments,supportFragmentManager,lifecycle)
        viewpager.adapter=adapter

        TabLayoutMediator(tablayout,viewpager){ tab, position ->
            tab.text=lsttitle[position]
        }.attach()

    }
    private fun populatelist(){
        lsttitle=ArrayList<String>()
        lsttitle.add("Home")
        lsttitle.add("Add student")
        lsttitle.add("About us")

        lstfragments= ArrayList<Fragment>()
        lstfragments.add(HomeFragment())
        lstfragments.add(AddStudent())
        lstfragments.add(AboutUs())
    }
}