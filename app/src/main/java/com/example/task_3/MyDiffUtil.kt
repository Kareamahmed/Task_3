package com.example.task_3

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil (
    private val newList : List<Item>,
    private val oldList: List<Item>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int =oldList.size


    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].image == newList[newItemPosition].image
    }
}