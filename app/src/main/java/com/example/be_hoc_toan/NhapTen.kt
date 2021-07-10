package com.example.be_hoc_toan



import android.content.Intent
import android.os.Build
import java.time.LocalDateTime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.format.DateTimeFormatter
class NhapTen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nhapten)


        val dong_y = findViewById<Button>(R.id.dong_y)
        val bangxh = findViewById<Button>(R.id.bangxh)
        val ten = findViewById<EditText>(R.id.ten)
        val gio_han_test = findViewById<EditText>(R.id.gioi_han_text)
        val currentDateTime = LocalDateTime.now()
        val statTime = currentDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"))


        dong_y.setOnClickListener{
            if(ten.text.toString()==""||gio_han_test.text.toString()=="")
            {
                Toast.makeText(this,"Bạn Phỉa nhập vào 2 ô trên",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, BaiTest::class.java)
                intent.putExtra("name", ten.text.toString())
                intent.putExtra("limit", gio_han_test.text.toString())
                intent.putExtra("start",statTime.toString())
                startActivity(intent)
            }

        }
        bangxh.setOnClickListener {
            val intent = Intent(this, BangXH::class.java)

            startActivity(intent)
        }
    }
}