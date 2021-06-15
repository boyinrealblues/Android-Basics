package com.example.fragmentandfragmentfactory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.fragmentandfragmentfactory.databinding.FragmentMainPageBinding

class MainPageFragment(private val dataSource : RemoteDataSource) : Fragment() {

    lateinit private var binding : FragmentMainPageBinding
    private var data : BTS
    init {
        data = dataSource.getBTS()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //what is container , inflater , inflate , DataBindingUtil
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initViews()
            binding.members.setOnClickListener{
                navigateToMembers()
            }
    }

    private fun navigateToMembers() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container,MembersFragment::class.java,null)
            .addToBackStack("MembersFragment").commit()

    }

    private fun initViews() {
        binding.title.setText(data.name)
        binding.description.setText(resources.getString(data.description))
        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/4/4f/BTS_for_Dispatch_White_Day_Special%2C_27_February_2019_01.jpg")
                .centerCrop().into(binding.image)
    }

}