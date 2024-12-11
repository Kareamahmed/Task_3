package com.example.task_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var items: List<Item> = emptyList()
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textItem)
        val imageView: ImageView = view.findViewById(R.id.imageItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text =item.name
        holder.imageView.setImageResource(item.image)

    }
    fun updateList(newList:List<Item>) {
        val myDiffUtil=MyDiffUtil(newList,items)
        val res = DiffUtil.calculateDiff(myDiffUtil)
        this.items = newList
        res.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int =items.size
}