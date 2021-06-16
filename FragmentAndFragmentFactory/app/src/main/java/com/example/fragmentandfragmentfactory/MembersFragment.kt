package com.example.fragmentandfragmentfactory

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentandfragmentfactory.databinding.FragmentMainPageBinding
import com.example.fragmentandfragmentfactory.databinding.FragmentMembersBinding

private const val TAG = "MembersFragment"
class MembersFragment(private val dataSource: RemoteDataSource) : Fragment() , BTSViewHolder.Interaction {

    lateinit private var binding : FragmentMembersBinding

      private var data : ArrayList<Members>

     init{
         data = dataSource.getBTS().Members
            Log.e(TAG , dataSource.getBTS().toString())
     }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_members,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BTSAdapter(data,this@MembersFragment)
        }
    }


        override fun onItemClick(view : View, position: Int) {

            val item = data[position]
            val bundle = Bundle()
            Log.e(TAG,item.name)
            bundle.putInt("army", item.id)
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, InfoFragment::class.java, bundle)
                        .addToBackStack("InfoFragment")
                        .commit()
        }
    }
