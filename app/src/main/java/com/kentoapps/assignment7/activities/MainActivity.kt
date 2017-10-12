package com.kentoapps.assignment7.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kentoapps.assignment7.R
import com.kentoapps.assignment7.fragments.StartFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, StartFragment.newInstance())
                .commit()
    }
}
