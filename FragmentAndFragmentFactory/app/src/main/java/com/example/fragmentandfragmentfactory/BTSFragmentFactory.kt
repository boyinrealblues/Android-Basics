package com.example.fragmentandfragmentfactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class BTSFragmentFactory(private val dataSource: RemoteDataSource) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

       if(className==MainPageFragment::class.java.name){
           return MainPageFragment(dataSource)
       }
        return super.instantiate(classLoader, className)
    }
}