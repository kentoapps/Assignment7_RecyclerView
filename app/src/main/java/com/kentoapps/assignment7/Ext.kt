package com.kentoapps.assignment7

/**
 * Created by kento on 2017/10/12.
 */
fun Int.addSuffix(suffix: Suffix): String =
        if (this <= 1) "$this ${suffix.singular}"
        else "$this ${suffix.plural}"

enum class Suffix(var singular: String, var plural: String) {
    LIKE("Like", "Likes"), COMMENT("Comment", "Comments")
}