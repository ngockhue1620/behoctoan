package com.example.be_hoc_toan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class BaiTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.giaodientest)
        val intent = intent
        Log.e("a","ok chay roi")
        val value1 = intent.getStringExtra("yes")
        val value2 = intent.getStringExtra("limit")
        Log.e("a",value1.toString())
        Log.e("a",value2.toString())
    }
}