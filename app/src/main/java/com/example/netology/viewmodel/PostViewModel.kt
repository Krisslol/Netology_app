package com.example.netology.viewmodel

import androidx.lifecycle.ViewModel
import com.example.netology.repository.PostRepository
import com.example.netology.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
   fun like() = repository.like()
    fun repost() = repository.repost()
    fun view() = repository.view()
  //  fun numberLike() = repository.numberLike()
   // fun numberRepost() = repository.numberRepost()
  // fun numberView() = repository.numberView()
}