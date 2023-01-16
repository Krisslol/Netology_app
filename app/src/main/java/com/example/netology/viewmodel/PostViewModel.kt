package com.example.netology.viewmodel

import androidx.lifecycle.ViewModel
import com.example.netology.repository.PostRepository
import com.example.netology.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    // упрощённый вариант
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
  fun likeById(id: Long) = repository.likeById(id)
   fun numberRepost(id: Long) = repository.numberRepost(id)
}
  //  fun numberLike() = repository.numberLike()
   // fun numberRepost() = repository.numberRepost()
  // fun numberView() = repository.numberView()
