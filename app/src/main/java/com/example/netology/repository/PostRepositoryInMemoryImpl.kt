package com.example.netology.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netology.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        published = "21 мая в 18:36",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        likedByMe = false,
        likes = 9999,
        reposts = 9999,
        repostedByMe = false,
        views = 9999,
        viewedByMe = false,
        numberLike = 9999,
        numberRepost = 9999,
        numberView = 9999,


        )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
        post = if (post.likedByMe) post.copy(numberLike = post.numberLike + 1)
        else post.copy(numberLike = post.numberLike - 1)
        data.value = post
    }

    override fun repost() {
        post = post.copy(repostedByMe = !post.repostedByMe)
        data.value = post
        post = post.copy(numberRepost = post.numberRepost + 1)
        data.value = post
    }

    override fun view() {
        post = post.copy(viewedByMe = !post.viewedByMe)
        data.value = post
        post = post.copy(numberView = post.numberView + 1)
        data.value = post
    }

    //override fun numberLike() {
    //   post = if (post.likedByMe) post.copy(numberLike = post.numberLike + 1)
    //         else post.copy(numberLike = post.numberLike - 1)
    //            data.value = post
    // }

    // override fun numberRepost() {
    //     post = post.copy(numberRepost = post.numberRepost + 1)
    //     data.value = post
    //  }

    // override fun numberView() {
    //  post = post.copy(numberView = post.numberView + 1)
    //     data.value = post
    //  }
}