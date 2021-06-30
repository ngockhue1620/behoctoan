package com.example.be_hoc_toan



import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NhapTen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nhapten)


        val dong_y = findViewById<Button>(R.id.dong_y)
        val ten = findViewById<EditText>(R.id.ten)
        val gio_han_test = findViewById<EditText>(R.id.gioi_han_text)


        dong_y.setOnClickListener{
            val i: Intent = Intent(this, BaiTest::class.java)
            intent.putExtra("yes", "Hello screen2!")
            intent.putExtra("limit", "Hello screen2!")
            startActivity(i)
        }
    }
}