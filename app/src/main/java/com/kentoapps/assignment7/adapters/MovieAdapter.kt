package com.kentoapps.assignment7.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kentoapps.assignment7.R
import com.kentoapps.assignment7.Suffix
import com.kentoapps.assignment7.addSuffix
import com.kentoapps.assignment7.models.DataSource
import com.kentoapps.assignment7.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import java.util.*

/**
 * Created by kento on 2017/10/11.
 */
class MovieAdapter(var movies: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, {
            DataSource.instance.removeMovie(movie)
            movies.remove(movie)
            notifyDataSetChanged()
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie, listener: (View) -> Unit) = with(itemView) {
            textAuthor.text = movie.profile.name
            textDate.text = movie.content.date.toString()
            textDesc.text = movie.content.body
            textLike.text = movie.feedback.likes.addSuffix(Suffix.LIKE)
            textComment.text = movie.feedback.comments.addSuffix(Suffix.COMMENT)
            buttonRemove.setOnClickListener(listener)
            setOnClickListener {
                Toast.makeText(context, movie.content.body, Toast.LENGTH_SHORT).show()
            }

            with(Picasso.with(context)) {
                println(movie.profile.imageUrl)
                load(movie.profile.imageUrl).into(imageAuthor)
                load(movie.content.imageUrl1).into(image1)
                load(movie.content.imageUrl2).into(image2)
            }
        }

    }

}