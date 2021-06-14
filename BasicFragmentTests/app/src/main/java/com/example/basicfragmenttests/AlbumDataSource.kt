package com.example.basicfragmenttests

interface AlbumDataSource {
    fun getAlbum(id : Int) : Album?
    fun getAlbums() : ArrayList<Album>
}
