package com.example.netology.dto

import java.math.RoundingMode
import java.text.DecimalFormat

data class Post(
    val id: Int,
    val author: String,
    val published: String,
    val content: String,
    var likedByMe: Boolean,
    var likes: Int,
    var reposts: Int,
    var repostedByMe: Boolean,
    var views: Int,
    var viewedByMe: Boolean,
    var numberLike:Int,
    var numberRepost:Int,
    var numberView:Int,


)

fun displayNumbers(number: Long): String {
    val decimalFormat = DecimalFormat("#.#")
    decimalFormat.roundingMode = RoundingMode.DOWN
    return when (number) {
        in 0..999 -> "$number"
        in 1000..9_999 -> "${decimalFormat.format(number.toFloat() / 1_000)}K"
        in 10_000..999_999 -> "${number / 1_000}K"
        in 1_000_000..9_999_999 -> "${decimalFormat.format(number.toFloat() / 1_000_000)}M"
        else -> "${number / 1_000_000}M"
    }
}