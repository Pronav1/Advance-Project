package com.pranavpandey.musicapp.model

data class SongModel(
    val title: String,
    val id: String,
    val subtitle: String,
    val url: String,
    val coverUrl: String
){
    constructor() : this("","","","","")
}
