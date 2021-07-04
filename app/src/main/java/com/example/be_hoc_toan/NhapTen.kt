package com.example.be_hoc_toan



import android.content.Intent
import android.os.Build
import java.time.LocalDateTime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.format.DateTimeFormatter
class NhapTen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nhapten)


        val dong_y = findViewById<Button>(R.id.dong_y)
        val ten = findViewById<EditText>(R.id.ten)
        val gio_han_test = findViewById<EditText>(R.id.gioi_han_text)
        val currentDateTime = LocalDateTime.now()
        val statTime = currentDateTime.format(DateTimeFormatter.ISO_TIME)

        dong_y.setOnClickListener{
            val intent = Intent(this, BaiTest::class.java)
            intent.putExtra("name", ten.text.toString())
            intent.putExtra("limit", gio_han_test.text.toString())
            intent.putExtra("start",statTime.toString())
            startActivity(intent)
        }
    }
}