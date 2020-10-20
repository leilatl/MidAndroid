package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_to_do.*

class InputToDo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_to_do)
        addNewItemButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", idEditText.text)
            intent.putExtra("title", titleEditText.text)
            intent.putExtra("description", descriptionEditText.text)
            intent.putExtra("status", statusEditText.text)
            intent.putExtra("category", categoryEditText.text)
            intent.putExtra("duration", durationEditText.text)
            startActivity(intent)
        }
    }
}