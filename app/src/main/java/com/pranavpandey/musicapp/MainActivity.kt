package com.pranavpandey.musicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.pranavpandey.musicapp.adapter.CategoryAdapter
import com.pranavpandey.musicapp.databinding.ActivityMainBinding
import com.pranavpandey.musicapp.model.CategoryModel
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCategories() // Call the function to fetch categories
    }

    private fun getCategories() {
        FirebaseFirestore.getInstance().collection("category")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(CategoryModel::class.java)
                setupCategoryRecyclerView(categoryList)
            }
    }

    private fun setupCategoryRecyclerView(categoryList: List<CategoryModel>) {
        categoryAdapter = CategoryAdapter(categoryList)
        binding.categoriesRecyclerView.adapter = categoryAdapter
        binding.categoriesRecyclerView.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}