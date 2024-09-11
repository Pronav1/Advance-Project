package com.pranavpandey.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pranavpandey.musicapp.adapter.SongListAdapter
import com.pranavpandey.musicapp.databinding.ActivitySongsListBinding
import com.pranavpandey.musicapp.model.CategoryModel

class SongsListActivity : AppCompatActivity() {
    companion object {
        lateinit var category: CategoryModel
    }

    private lateinit var binding: ActivitySongsListBinding
    private lateinit var songsListAdapter: SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySongsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTextView.text = category.name

        setupSongRecyclerView()
    }

    private fun setupSongRecyclerView() {
        songsListAdapter = SongListAdapter(category.songs)
        binding.songsListRecyclerView.adapter = songsListAdapter
    }
}