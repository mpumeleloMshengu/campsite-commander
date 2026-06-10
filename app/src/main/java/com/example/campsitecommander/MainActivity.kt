package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val items = Array(10) { "" }
    val categories = Array(10) { "" }
    val quantities = IntArray(10)
    val comments = Array(10) { "" }

    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etItem = findViewById<EditText>(R.id.etItem)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComment = findViewById<EditText>(R.id.etComment)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)

        btnAdd.setOnClickListener {

            val item = etItem.text.toString()
            val category = etCategory.text.toString()
            val comment = etComment.text.toString()
            val quantity = etQuantity.text.toString().toIntOrNull()

            if (item.isEmpty() || quantity == null) {
                etItem.error = "Enter valid data"
                return@setOnClickListener
            }

            items[index] = item
            categories[index] = category
            quantities[index] = quantity
            comments[index] = comment

            index++

            var total = 0
            for (i in 0 until index) {
                total += quantities[i]
            }

            tvTotal.text = "Total Packed: $total"
        }

        btnView.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("items", items)
            intent.putExtra("categories", categories)
            intent.putExtra("quantities", quantities)
            intent.putExtra("comments", comments)

            startActivity(intent)
        }
    }
}
