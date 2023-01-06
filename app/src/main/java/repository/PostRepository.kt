package repository

import androidx.lifecycle.LiveData
import com.example.netology.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun repost()
    fun view()
    fun numberLike()
    fun numberRepost()
    fun numberView()
}