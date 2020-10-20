package com.example.midterm

import android.view.LayoutInflater
import android.content.Intent
import android.util.Log
import android.widget.Toast
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter constructor(private val itemClickListener: (position:Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var toDoList: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContactViewHolder).bind(toDoList[position], itemClickListener)

    }

    fun addItems(list: List<Task>) {
        toDoList.clear()
        toDoList.addAll(list)
        notifyDataSetChanged()
    }

    fun addElement(item:Task){
        toDoList.add(item)
        notifyDataSetChanged()
    }

    private class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

        private val titleTextView = itemView.titleTextView
        private val statusTextView = itemView.statusTextView
        private val categoryTextView = itemView.categoryTextView
        private val toDoItemLayout = itemView.toDoItemLayout

        fun bind(item: Task, itemClickListener: (position: Int) -> Unit) {
            titleTextView.text = item.title
            statusTextView.text = item.status
            categoryTextView.text = item.category
            toDoItemLayout.setOnClickListener {
                itemClickListener(adapterPosition)
            }
        }

    }
}