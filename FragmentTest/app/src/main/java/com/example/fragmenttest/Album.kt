package com.example.fragmenttest

//Data Class Defining the basic object used in the app
data class Album(
    val id : Int ,
    val title : String ,
    val description : String ,
    val artists : List<String> ,
    val awards : List<String> ,
    val songs : List<String>
)