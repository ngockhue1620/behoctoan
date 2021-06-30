package com.example.be_hoc_toan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val learn = findViewById<Button>(R.id.learn)
        val test = findViewById<Button>(R.id.test)


        learn.setOnClickListener{
            val i: Intent = Intent(this, HocTap::class.java)
            startActivity(i)
        }
        test.setOnClickListener{
            val i: Intent = Intent(this, NhapTen::class.java)
            startActivity(i)
        }
    }
}