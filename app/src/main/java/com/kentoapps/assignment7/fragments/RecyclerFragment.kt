package com.kentoapps.assignment7.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kentoapps.assignment7.R
import com.kentoapps.assignment7.adapters.MovieAdapter
import com.kentoapps.assignment7.models.DataSource
import kotlinx.android.synthetic.main.fragment_recycler.*

class RecyclerFragment : Fragment() {
    private var isCreated = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context,
                LinearLayoutManager(context).orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        buttonLoad.setOnClickListener {
            if (!isCreated) {
                textEmpty.visibility = View.GONE
                DataSource.instance.createFakeNews()
                recyclerView.adapter = MovieAdapter(DataSource.instance.movies)
                isCreated = true
            }
        }

        buttonAdd.setOnClickListener {
            val fragment = AddFragment.newInstance()
            fragment.setTargetFragment(this, 1)
            fragmentManager.beginTransaction()
                    .add(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        fun newInstance(): RecyclerFragment {
            return RecyclerFragment()
        }
    }

    fun refresh() {
        (recyclerView.adapter as MovieAdapter).movies = DataSource.instance.movies
        recyclerView.adapter.notifyDataSetChanged()
    }
}
