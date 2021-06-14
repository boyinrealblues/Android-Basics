package com.example.fragmentandfragmentfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var dataSource : RemoteDataSource

    init{
        dataSource = RemoteDataSource()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = BTSFragmentFactory(dataSource)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction().replace(R.id.container,MainPageFragment::class.java,null).addToBackStack("MainPageFragment").commit()
        }
    }

}