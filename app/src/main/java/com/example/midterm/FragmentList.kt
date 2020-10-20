package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

class FragmentList(list: MutableList<Task>) : Fragment() {

    private var toDoAdapter: Adapter? = null
    private var toDoList = list
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toDoAdapter = Adapter(
            itemClickListener = {
                val intent = Intent(context, ItemDetail::class.java)
                intent.putExtra("id", toDoList[it].ID.toString())
                intent.putExtra("title", toDoList[it].title)
                intent.putExtra("description", toDoList[it].description)
                intent.putExtra("status", toDoList[it].status)
                intent.putExtra("category", toDoList[it].category)
                intent.putExtra("duration", toDoList[it].duration)
                startActivity(intent)
            }
        )
        val manager = LinearLayoutManager(context)
        toDoRecyclerView.apply {
            layoutManager = manager
            adapter = toDoAdapter
        }
        toDoAdapter?.addItems(toDoList)

    }

    fun addItem(item: Task) {
        toDoAdapter?.addElement(item)
    }
}