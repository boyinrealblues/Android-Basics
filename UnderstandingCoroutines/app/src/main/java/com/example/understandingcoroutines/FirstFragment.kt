package com.example.understandingcoroutines

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.understandingcoroutines.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

private const val TAG = "FirstFragment"
class FirstFragment : Fragment() {
    var c=0

    lateinit private var binding : FragmentFirstBinding

    val scope = CoroutineScope(CoroutineName("MyScope"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scope1.setOnClickListener {
            if(c==0) {
                scopeInGlobal()
                c++
            }
        }

        binding.scope2.setOnClickListener {
            if(c==0) {
              scopeInLifecycle()
                c++
          }
        }

        binding.scope3.setOnClickListener {

            if(c==0) {
                scopeInCustom()
                c++
            }
        }
        binding.navigate.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container,SecondFragment::class.java,null).addToBackStack("SecondFragment").commit()
        }
    }

    private fun scopeInGlobal(){

        GlobalScope.launch {
            while(true){
                Log.e(TAG,"Running. in GlobalScope..")
                delay(1000L)
            }
        }

    }

    private fun scopeInLifecycle(){

        lifecycleScope.launch {
            while(true){
                Log.e(TAG,"Running in LifecycleScope...")
                delay(1000L)
            }
        }

    }

    private fun scopeInCustom(){

        scope.launch {
            while(true){
                Log.e(TAG,"Running in CustomScope...")
                delay(1000L)
            }
        }

    }
    override fun onStop() {
        super.onStop()

        Log.e(TAG,"Stopped")
    }

    override fun onResume() {
        super.onResume()

        Log.e(TAG,"Resumed")
    }

    override fun onPause() {
        super.onPause()

        Log.e(TAG,"Paused")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e(TAG,"Destroyed")
    }

    override fun onStart() {
        super.onStart()

        Log.e(TAG,"Started")
    }


}

