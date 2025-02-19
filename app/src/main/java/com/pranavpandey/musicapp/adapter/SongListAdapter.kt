package com.pranavpandey.musicapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.pranavpandey.musicapp.databinding.SongListItemRecyclerRowBinding
import com.pranavpandey.musicapp.model.SongModel

class SongListAdapter(private val songList: String): RecyclerView.Adapter<SongListAdapter.MyViewHolder>(){

class MyViewHolder(private val binding: SongListItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
    fun bindData(songId: String){
        FirebaseFirestore.getInstance().collection("songs").document(songId).get().addOnSuccessListener {
            val song = it.toObject(SongModel::class.java)
            song?.apply{
                binding.songTitleTextView.text = title
                binding.songSubtitleTextView.text = subtitle
                Glide.with(binding.songCoverImageView)
                    .load(coverUrl)
                    .apply(RequestOptions().transform(RoundedCorners(32)))
                    .into(binding.songCoverImageView)
            }
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = SongListItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return songList.length
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bindData(songList[position].toString())
    }
}