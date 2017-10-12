package com.kentoapps.assignment7.models

/**
 * Created by kento on 2017/09/26.
 */

data class Feedback(var likes: Int, var comments: Int) {

    fun incrementLikes() {
        likes++
    }

    fun incrementComments() {
        comments++
    }
}
