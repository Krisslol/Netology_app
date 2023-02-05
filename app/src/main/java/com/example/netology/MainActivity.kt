package com.example.netology

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.netology.adapter.PostsAdapter
import com.example.netology.databinding.ActivityMainBinding
import com.example.netology.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter =  PostsAdapter (
            onLikeListener = { viewModel.likeById(it.id.toLong()) },
            onRepostListener = { viewModel.numberRepost(it.id.toLong()) }

        )
        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }

}