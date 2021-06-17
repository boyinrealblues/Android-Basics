package com.example.understandingcoroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.understandingcoroutines.databinding.FragmentFirstBinding
import com.example.understandingcoroutines.databinding.FragmentSecondBinding


class FirstFragment : Fragment() {

    lateinit private var binding : FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigate.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container,SecondFragment::class.java,null).addToBackStack("SecondFragment").commit()
        }
    }

}