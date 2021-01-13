package com.varenie.testtask

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MyAdapter(list: ArrayList<Int>): RecyclerView.Adapter<MyAdapter.MyHolder>() {
    val list = list
    val deletedItems = ArrayList<Int>()

    init {
        val mTimer = Timer()
        val mTask = MyTimerTask(list, deletedItems)

        mTimer.schedule(mTask, 5000, 5000)
    }

    class MyHolder(itemView: View, ): RecyclerView.ViewHolder(itemView) {
        val tvNumber = itemView.findViewById<TextView>(R.id.tv_number)
        val btnDelete = itemView.findViewById<Button>(R.id.btn_delete)

        fun bind(position: Int, list: ArrayList<Int>) {
            tvNumber.text = list.get(position).toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item, null)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        holder.bind(position, list)

        holder.btnDelete.setOnClickListener {
            notifyItemRemoved(position)
            deletedItems.add(list.removeAt(position))
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, list.size)
        }

    }

    override fun getItemCount(): Int {
        return list.size
        Log.e("OCHKO", list.size.toString())
    }


}