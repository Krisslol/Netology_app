package com.example.netology.repository

import androidx.lifecycle.LiveData
import com.example.netology.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun numberRepost(id: Long)
}