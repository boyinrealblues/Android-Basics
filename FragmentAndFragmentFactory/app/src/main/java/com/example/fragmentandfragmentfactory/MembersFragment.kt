package com.example.fragmentandfragmentfactory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.fragmentandfragmentfactory.databinding.FragmentMainPageBinding
import com.example.fragmentandfragmentfactory.databinding.FragmentMembersBinding

class MembersFragment() : Fragment() {

    lateinit private var binding : FragmentMembersBinding

     lateinit private var data : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            arguments?.let{
                it.getStringArrayList("bts")?.let{
                    data = it
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //what is container , inflater , inflate , DataBindingUtil
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_members,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initializeView()
    }

    private fun initializeView() {
        var sb = StringBuilder()
        for(member in data){
            sb=sb.append("${member}\n")
        }
        binding.membersList.setText(sb.toString())
    }
}