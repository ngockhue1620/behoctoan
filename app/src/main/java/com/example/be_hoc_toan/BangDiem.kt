package com.example.be_hoc_toan



import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BangDiem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bangdiem)

        var intent = intent
        var ketqua = intent.getStringExtra("ketqua")

        val diem = findViewById<TextView>(R.id.diem)
        val thongbao = findViewById<TextView>(R.id.thong_bao)
        val home = findViewById<Button>(R.id.home)
        thongbao.setText("Bạn Đạt được"+ketqua.toString()+"/10 câu")
        diem.setText(ketqua.toString())

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }




    }
}