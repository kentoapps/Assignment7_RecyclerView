package com.kentoapps.assignment7.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.kentoapps.assignment7.R
import com.kentoapps.assignment7.models.*
import kotlinx.android.synthetic.main.fragment_add.*
import java.util.*


class AddFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave.setOnClickListener {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)

            DataSource.instance.addMovie(Movie(Profile("http://buzzshogun.com/wp-content/uploads/2016/09/7a2f6202b294be4068ea26abdcff2698-300x255.png", "LiLiCo"),
                    Content(Date(), editBody.text.toString(), "http://www.unsungfilms.com/wp-content/uploads/2014/12/iris_04.jpg", "http://cassavafilms.com/wp-content/uploads/2013/01/iris.jpg"),
                    Feedback(0, 0)))
            (targetFragment as RecyclerFragment).refresh()
            fragmentManager.popBackStack()
        }
    }

    companion object {
        fun newInstance(): AddFragment {
            return AddFragment()
        }
    }

}