package com.example.basicfragmenttests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.basicfragmenttests.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit private var  binding : ActivityMainBinding
    lateinit private var remoteDataSource:RemoteAlbumDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = AlbumFragmentFactory(remoteDataSource)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initDependencies() {
        if(!::remoteDataSource.isInitialized){
            remoteDataSource = RemoteAlbumDataSource()
        }
    }
}