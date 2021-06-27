package com.example.be_hoc_toan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
            val i: Intent = Intent(this, BaiTest::class.java)
            startActivity(i)
        }
    }
}