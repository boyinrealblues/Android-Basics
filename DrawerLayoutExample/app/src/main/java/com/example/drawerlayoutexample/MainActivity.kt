package com.example.drawerlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.databinding.DataBindingUtil
import com.example.drawerlayoutexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
 lateinit private var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener{
            //openDrawer(__Define in which gravity the view is located__)
                binding.drawerLayout.openDrawer(Gravity.LEFT)
        }
        binding.navigationView.setNavigationItemSelectedListener {menuItem->
            //openDrawer(__Define in which gravity the view needs to be moved__)
            menuItem.isChecked =true
            binding.drawerLayout.closeDrawer(Gravity.LEFT)
            true
        }

    }
}