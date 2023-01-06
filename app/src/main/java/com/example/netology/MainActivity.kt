package com.example.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netology.databinding.ActivityMainBinding
import viewmodel.PostViewModel
import androidx.activity.viewModels
import com.example.netology.dto.displayNumbers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                numberRepost.text = post.reposts.toString()
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                )
                numberLike.text = displayNumbers(post.numberLike.toLong())
                numberRepost.text = displayNumbers(post.numberRepost.toLong())
                numberView.text = displayNumbers(post.numberView.toLong())
            }

        }
        binding.like.setOnClickListener {
           viewModel.like()
            viewModel.numberLike()
        }
        binding.repost.setOnClickListener {
            viewModel.numberRepost()
            //viewModel.repost()
        }
        binding.view.setOnClickListener {
            viewModel.numberView()
          //  viewModel.view()
        }

    }
}
