package com.example.taskcoffe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskcoffe.R

class FragmentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_cont, BlankFragment(), "frag")
            .addToBackStack("frag")
            .commit()


    }


}