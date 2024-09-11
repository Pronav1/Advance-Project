package com.pranavpandey.musicapp.model

data class CategoryModel (
    val name: String,
    val cover: String,
    val songs: String
){
    constructor() : this("","","")
}