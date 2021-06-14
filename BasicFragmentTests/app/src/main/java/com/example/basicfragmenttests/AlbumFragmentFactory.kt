package com.example.basicfragmenttests

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.ListFragment

class AlbumFragmentFactory(private val remoteDataSource: RemoteAlbumDataSource) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        when(className) {
            is FragmentList::class.java.name ->{
                       FragmentList(remoteDataSource)
            }
            is FragmentDetail ->{}

            else-> return super.instantiate(classLoader, className)
        }
    }
}
