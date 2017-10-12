package com.kentoapps.assignment7.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter
import com.afollestad.sectionedrecyclerview.SectionedViewHolder
import com.kentoapps.assignment7.R
import com.kentoapps.assignment7.Suffix
import com.kentoapps.assignment7.addSuffix
import com.kentoapps.assignment7.models.DataSource
import com.kentoapps.assignment7.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.recycler_item_header.view.*
import java.util.*

/**
 * Created by kento on 2017/10/11.
 */
class MovieAdapter(var movies: ArrayList<Movie>) : SectionedRecyclerViewAdapter<MovieAdapter.ViewHolder>() {

    override fun getItemCount(section: Int): Int {
        val newMovies = movies.filter { !it.content.isOlderThan5years() }
        val oldMovies = movies.filter { it.content.isOlderThan5years() }
        return when (section) {
            0 -> newMovies.size
            1 -> oldMovies.size
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when (viewType) {
            SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER -> R.layout.recycler_item_header
            SectionedRecyclerViewAdapter.VIEW_TYPE_ITEM -> R.layout.recycler_item
            else -> R.layout.recycler_item_bold
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, section: Int, relativePosition: Int, absolutePosition: Int) {
        val newMovies = movies.filter { !it.content.isOlderThan5years() }
        val oldMovies = movies.filter { it.content.isOlderThan5years() }
        val movie = if (section == 0)
            newMovies[relativePosition]
        else
            oldMovies[relativePosition]
        holder.bind(movie) {
            DataSource.instance.removeMovie(movie)
            movies.remove(movie)
            notifyDataSetChanged()
        }
    }

    override fun getSectionCount(): Int = 2

    override fun onBindHeaderViewHolder(holder: ViewHolder, section: Int, expanded: Boolean) {
        holder.bindHeader(this, expanded, section)
    }

    override fun onBindFooterViewHolder(holder: ViewHolder, section: Int) {}

    class ViewHolder(view: View) : SectionedViewHolder(view) {
        fun bind(movie: Movie, listener: (View) -> Unit) = with(itemView) {
            textAuthor.text = movie.profile.name
            textDate.text = movie.content.date.toString()
            textDesc.text = "${movie.content.getYear()}\n${movie.content.body}"
            textLike.text = movie.feedback.likes.addSuffix(Suffix.LIKE)
            textComment.text = movie.feedback.comments.addSuffix(Suffix.COMMENT)
            buttonRemove.setOnClickListener(listener)
            setOnClickListener {
                Toast.makeText(context, movie.content.body, Toast.LENGTH_SHORT).show()
            }

            with(Picasso.with(context)) {
                load(movie.profile.imageUrl).into(imageAuthor)
                load(movie.content.imageUrl1).into(image1)
                load(movie.content.imageUrl2).into(image2)
            }
        }

        fun bindHeader(adapter: MovieAdapter, expanded: Boolean, section: Int) = with(itemView) {
            title.text = if (section == 0) "Latest Movies" else "Old Movies"
            caret.setImageResource(if (expanded) R.drawable.ic_collapse else R.drawable.ic_expand)
            setOnClickListener {
                adapter.toggleSectionExpanded(section)
            }
        }

    }

}