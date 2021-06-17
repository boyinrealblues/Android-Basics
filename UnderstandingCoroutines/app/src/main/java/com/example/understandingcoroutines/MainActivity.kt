package com.example.understandingcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.understandingcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit private var binding : ActivityMainBinding

    val scope = CoroutineScope(CoroutineName("MyScope"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        if(supportFragmentManager.fragments.size == 0 ){
            updateView()
        }
    }

    private fun updateView() {

        scope.launch {
            Log.e(TAG, this.coroutineContext.toString())
        }
        supportFragmentManager.beginTransaction().replace(R.id.container,FirstFragment::class.java,null).addToBackStack("FirstFragment").commit()
    }
}