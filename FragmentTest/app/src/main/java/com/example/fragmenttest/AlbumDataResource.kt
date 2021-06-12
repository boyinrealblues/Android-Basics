package com.example.fragmenttest

//Class to architect data via MutableMap

class AlbumDataResource : AlbumInterface {



    lateinit private var fakeData : MutableMap<Int , Album>

    init{
        addData()
    }

    private fun addData() {
      
        for(i in 0..AlbumInstance.album.size){
  
            //Filled with data from instance
      
            fakeData.put(AlbumInstance.album[i].id , AlbumInstance.album[i])

        }
    }

    override fun getMovie(id: Int): Album {
        return fakeData.get(id)!!
    }

    override fun getMovies(): ArrayList<Album> {
        return fakeData.values as ArrayList<Album>
    }


}