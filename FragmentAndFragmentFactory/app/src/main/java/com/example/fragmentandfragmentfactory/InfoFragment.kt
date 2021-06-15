package com.example.fragmentandfragmentfactory

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.fragmentandfragmentfactory.databinding.FragmentInfoBinding

private const val TAG = "InfoFragment"
class InfoFragment(val dataSource: RemoteDataSource) : Fragment() {
init {
    Log.e(TAG, "came")
}
    lateinit private var member : Members
    lateinit private var binding : FragmentInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            it.getInt("army")?.let{
                member = dataSource.getMember(it)
            }
        }
       }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_info , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initializeMember()
    }

    private fun initializeMember() {
        Glide.with(this).load(member.image).into(binding.imageBts)

        binding.textView4.setText(member.role)
        binding.descriptionBts.setText(member.descripition)
        binding.nameBts.setText(member.name)
    }

}