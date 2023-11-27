package com.example.snoepjes

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class ListAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Find views
        val editText = findViewById<EditText>(R.id.etAddPerson)
        val addButton = findViewById<Button>(R.id.btnAddPerson)
        val gridView = findViewById<GridView>(R.id.gvPersonView)

        // Create an ArrayList to hold data for the GridView
        val dataList = ArrayList<String>() // Change String to your desired data type

        // Set up adapter for the GridView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList)
        gridView.adapter = adapter

        // Add a click listener to the button to add EditText data to GridView
        addButton.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isNotEmpty()) {
                dataList.add(inputText)
                adapter.notifyDataSetChanged() // Notify adapter about the data change
                editText.text.clear() // Clear the EditText after adding data
            }
        }
    }
}

