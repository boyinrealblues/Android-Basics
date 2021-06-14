package com.example.basicfragmenttests

data class Album(
    val id : Int ,
    val title : String ,
    val image : String ,
    val description : String,
    val songs : List<String>,
    val awards : List<String>,
    val artists : List<String>
)
