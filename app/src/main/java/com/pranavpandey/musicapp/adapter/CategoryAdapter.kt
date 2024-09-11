package com.pranavpandey.musicapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pranavpandey.musicapp.SongsListActivity
import com.pranavpandey.musicapp.databinding.CategoryItemRecyclerRowBinding
import com.pranavpandey.musicapp.model.CategoryModel

class CategoryAdapter (private val categoryList: List<CategoryModel>)
    : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding : CategoryItemRecyclerRowBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bindData(category: CategoryModel) {
         binding.nameTextView.text = category.name
            Glide.with(binding.coverImageView)
                .load(category.cover)
                .apply(RequestOptions().transform(RoundedCorners(32)))
                .into(binding.coverImageView)

            val context = binding.root.context
            binding.root.setOnClickListener{
                SongsListActivity.category = category
                context.startActivity(Intent(context, SongsListActivity::class.java))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
val binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }

}

/*

Imagine you have a cool music app, and you want to show different music categories
 like Pop, Rock, Jazz, etc., in a nice list on the screen. This CategoryAdapter is
  like a helpful tool that takes those categories and displays them neatly.
Think of it like this: you have a bunch of music posters (categories), and you want
 to put them up on a bulletin board (your app screen). This adapter is like the pins
  and tape that help you organize and display those posters.
Here's how it works:
CategoryAdapter: This is the main organizer. It takes a list of categories (like a
 stack of posters) and figures out how to display them.
MyViewHolder: This is like a frame for each poster. It holds the poster and makes
 sure it's displayed correctly.
bindData: This is where you actually put the poster in the frame. It takes the category
 information (poster) and sets the text on the frame (like writing the category name on the poster).
onCreateViewHolder: This is like getting a new frame when you need to display a new
 poster. It creates the frame using a blueprint (the CategoryItemRecyclerRowBinding).
getItemCount: This simply tells you how many posters you have in your stack.
onBindViewHolder: This is where you take each frame (poster holder) and put the right
 poster in it. It matches the frame with the correct poster from your stack.
So basically:
This code takes a list of music categories, creates a frame for each category, puts
the category name on the frame, and then displays all the frames in a list on your
app screen. It's like a little organizer that helps your app show things in a neat and tidy way!
Do you have any other questions about how this works? Maybe you want to know how to
make the posters clickable or add cool images to them? Just ask!*/