package com.example.understandingcoroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.understandingcoroutines.databinding.ActivityMainBinding
import com.example.understandingcoroutines.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit private var binding : FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)
        return binding.root
    }

}