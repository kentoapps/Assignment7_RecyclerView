package com.kentoapps.assignment7.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kentoapps.assignment7.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBegin.setOnClickListener {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, RecyclerFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }

}
