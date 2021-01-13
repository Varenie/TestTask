package com.varenie.testtask

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Int>()
        
        for (i in 0..15){
            list.add(i, i)
        }

        val myRecycler = findViewById<RecyclerView>(R.id.myRecycler)
        myRecycler.layoutManager = GridLayoutManager(this, getScreenOrientation())
        myRecycler.itemAnimator = DefaultItemAnimator()

        val adapter = MyAdapter(list)
        myRecycler.adapter = adapter
    }

//  для изменения столбцов при смене ориентации
    private fun getScreenOrientation(): Int {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2
        else if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4
        else 0
    }
}