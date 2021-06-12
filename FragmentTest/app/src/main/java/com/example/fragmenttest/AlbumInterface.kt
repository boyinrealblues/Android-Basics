package com.example.fragmenttest

interface AlbumInterface {

    //Interface providing getter methods to AlbumDataResource

    fun getMovie(id:Int):Album
    fun getMovies():ArrayList<Album>
}