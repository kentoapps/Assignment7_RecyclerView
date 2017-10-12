package com.kentoapps.assignment7.models

import java.util.*

/**
 * Created by kento on 2017/09/26.
 */

class DataSource private constructor() {
    val movies = ArrayList<Movie>()
    private var isCreated = false

    fun addMovie(movie: Movie) {
        movies.add(movie)
    }

    fun removeMovie(movie: Movie) {
        movies.remove(movie)
    }

    fun createFakeNews() {
        if (isCreated) return
        movies.add(Movie(
                Profile("http://file.tomodachi.game-ss.com/002.jpg", "Osugi"),
                Content(Date(), "1. \"The Usual Suspects\"\n\nA sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.", "https://ewedit.files.wordpress.com/2015/08/the-usual-suspects_0_0.jpg?w=612", "https://i.guim.co.uk/img/media/07ee94da601f3f949e72d0307884db3d324426f5/0_186_3328_1995/master/3328.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=98351d988cb2c14280a1741408b6e6f0"),
                Feedback(1, 2)))
        movies.add(Movie(
                Profile("http://file.tomodachi.game-ss.com/002.jpg", "Osugi"),
                Content(Date(), "2. \"The Usual Suspects\"\n\n" +
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.", "https://ewedit.files.wordpress.com/2015/08/the-usual-suspects_0_0.jpg?w=612", "https://i.guim.co.uk/img/media/07ee94da601f3f949e72d0307884db3d324426f5/0_186_3328_1995/master/3328.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=98351d988cb2c14280a1741408b6e6f0"),
                Feedback(10, 2)))
        movies.add(Movie(
                Profile("http://file.tomodachi.game-ss.com/002.jpg", "Osugi"),
                Content(Date(), "3. \"The Usual Suspects\"\n\n" +
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.", "https://ewedit.files.wordpress.com/2015/08/the-usual-suspects_0_0.jpg?w=612", "https://i.guim.co.uk/img/media/07ee94da601f3f949e72d0307884db3d324426f5/0_186_3328_1995/master/3328.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=98351d988cb2c14280a1741408b6e6f0"),
                Feedback(3, 2)))
        movies.add(Movie(
                Profile("http://file.tomodachi.game-ss.com/002.jpg", "Osugi"),
                Content(Date(), "4. \"The Usual Suspects\"\n\n" +
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.", "https://ewedit.files.wordpress.com/2015/08/the-usual-suspects_0_0.jpg?w=612", "https://i.guim.co.uk/img/media/07ee94da601f3f949e72d0307884db3d324426f5/0_186_3328_1995/master/3328.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=98351d988cb2c14280a1741408b6e6f0"),
                Feedback(0, 2)))
        movies.add(Movie(
                Profile("http://file.tomodachi.game-ss.com/002.jpg", "Osugi"),
                Content(Date(), "5. \"The Usual Suspects\"\n\n" +
                        "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which began when five criminals met at a seemingly random police lineup.", "https://ewedit.files.wordpress.com/2015/08/the-usual-suspects_0_0.jpg?w=612", "https://i.guim.co.uk/img/media/07ee94da601f3f949e72d0307884db3d324426f5/0_186_3328_1995/master/3328.jpg?w=300&q=55&auto=format&usm=12&fit=max&s=98351d988cb2c14280a1741408b6e6f0"),
                Feedback(2, 2)))
        isCreated = true
    }

    companion object {
        val instance = DataSource()
    }
}
