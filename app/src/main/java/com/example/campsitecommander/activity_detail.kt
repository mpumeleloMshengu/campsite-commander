package com.example.campsitecommander   // ⚠️ change ONLY if your package is different

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val items = intent.getStringArrayExtra("items")
        val categories = intent.getStringArrayExtra("categories")
        val quantities = intent.getIntArrayExtra("quantities")
        val comments = intent.getStringArrayExtra("comments")

        val list = ArrayList<String>()

        if (items != null && categories != null && quantities != null && comments != null) {
            for (i in items.indices) {
                list.add("${items[i]} | ${categories[i]} | Qty: ${quantities[i]} | ${comments[i]}")
            }
        }
    }
}

