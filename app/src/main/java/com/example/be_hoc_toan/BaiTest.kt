package com.example.be_hoc_toan

import android.content.Intent
import android.graphics.Color
import android.graphics.Color.green
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


class BaiTest : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.giaodientest)
        var intent = intent
        var name = intent.getStringExtra("name")
        var gioi_han = intent.getStringExtra("limit")
        var startTime = intent.getStringExtra("start")
        var back_images = arrayOf(R.drawable.anh1,R.drawable.toan2,R.drawable.toan1,R.drawable.toan3,R.drawable.toan4,R.drawable.toan5,R.drawable.toan6,R.drawable.toan7)
        val screenView = findViewById<LinearLayout>(R.id.linear_layout1)
        val a = findViewById<Button>(R.id.A)
        val b = findViewById<Button>(R.id.B)
        val c = findViewById<Button>(R.id.C)
        val d = findViewById<Button>(R.id.D)
        val pheptinh = findViewById<TextView>(R.id.pheptinh)
        val next = findViewById<Button>(R.id.next)
        val sl_cau_hoi = findViewById<TextView>(R.id.sl_cau_hoi)
        var so_luong: Int = 1
        var ket_qua: Int = 0
        var ket_qua_phep_tinh = 0
        fun bai_toan_khac(){

            val lay_gioi_han = gioi_han.toString().toInt()
            val randomValues = List(2) { Random.nextInt(0, lay_gioi_han) }.toMutableList()
            println(randomValues)
            val toan_tu = arrayOf("+","-","*","/")
            val random_toan_tu = Random.nextInt(0,4)
            var vi_tri_thong_bao =random_toan_tu
            println(toan_tu[random_toan_tu])
            if( random_toan_tu==0)
            {
                if(randomValues[0]+randomValues[1]>=lay_gioi_han)
                {
                    randomValues[0] = (randomValues[0]/2).toInt()
                    randomValues[1] = (randomValues[1]/2).toInt()
                }
                ket_qua_phep_tinh=randomValues[0]+randomValues[1]
            }

            else if(random_toan_tu==2)
            {
                while (randomValues[0]*randomValues[1]>=lay_gioi_han){
                    randomValues[0] =  (randomValues[0]/10).toInt()
                    randomValues[1] = (randomValues[1]/10).toInt()
                    if( randomValues[0]*randomValues[1]>=lay_gioi_han)
                    {
                        randomValues[0] = (randomValues[0]/10).toInt()
                        if( randomValues[0]*randomValues[1]>lay_gioi_han)
                        {
                            randomValues[0] = (randomValues[0]/10).toInt()
                        }
                    }
                }
                ket_qua_phep_tinh=randomValues[0]*randomValues[1]
            }
            else if( random_toan_tu==3)
            {
                if( randomValues[1]>randomValues[0])
                {
                    val temp = randomValues[0]
                    randomValues[0] = randomValues[1]
                    randomValues[1] = temp
                }
                randomValues[0] = randomValues[0] - randomValues[0]%randomValues[1]

                ket_qua_phep_tinh=randomValues[0]/randomValues[1]


            }
            else
            {
                if(randomValues[0]-randomValues[1]<0)
                {
                    val temp = randomValues[0]
                    randomValues[0] = randomValues[1]
                    randomValues[1] = temp
                }
                ket_qua_phep_tinh=randomValues[0]-randomValues[1]
            }
            println(ket_qua_phep_tinh)
            val dap_an: IntArray = intArrayOf(0, 0, 0, 0)

            var pt = randomValues[0].toString()+toan_tu[random_toan_tu]+randomValues[1].toString()
            pheptinh.setText(pt)
            val vi_tri_dap_an_dung = Random.nextInt(0,4)
            dap_an[vi_tri_dap_an_dung] = ket_qua_phep_tinh

            for (i in 0..3) {
                if(i!=vi_tri_dap_an_dung){
                    dap_an[i] = ket_qua_phep_tinh-vi_tri_dap_an_dung+i
                }
            }

            a.setText(dap_an[0].toString())
            b.setText(dap_an[1].toString())
            c.setText(dap_an[2].toString())
            d.setText(dap_an[3].toString())


            a.setOnClickListener{
                a.setBackgroundColor(Color.GREEN)
                d.setBackgroundColor(Color.WHITE)
                b.setBackgroundColor(Color.WHITE)
                c.setBackgroundColor(Color.WHITE)
                val kq_truyen_vao = a.text.toString()
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    ket_qua+=1

                }else{
                    ket_qua-=1
                }

            }
            b.setOnClickListener{
                val kq_truyen_vao = b.text.toString()
                b.setBackgroundColor(Color.GREEN)
                a.setBackgroundColor(Color.WHITE)
                d.setBackgroundColor(Color.WHITE)
                c.setBackgroundColor(Color.WHITE)
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    ket_qua+=1

                }else{
                    ket_qua-=1
                }
            }
            c.setOnClickListener{
                val kq_truyen_vao = c.text.toString()
                c.setBackgroundColor(Color.GREEN)
                a.setBackgroundColor(Color.WHITE)
                b.setBackgroundColor(Color.WHITE)
                d.setBackgroundColor(Color.WHITE)
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    ket_qua+=1

                }else{
                    ket_qua-=1
                }

            }
            d.setOnClickListener{
                val kq_truyen_vao = d.text.toString()
                d.setBackgroundColor(Color.GREEN)
                a.setBackgroundColor(Color.WHITE)
                b.setBackgroundColor(Color.WHITE)
                c.setBackgroundColor(Color.WHITE)
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    ket_qua+=1

                }else{
                    ket_qua-=1
                }
            }
            Log.e("bbb",ket_qua.toString())
        }
        bai_toan_khac()
        next.setOnClickListener{

            so_luong+=1
            if(so_luong==11){
                val context = this
                val currentDateTime = LocalDateTime.now()
                val endTime = currentDateTime.format(DateTimeFormatter.ISO_TIME)
                var user = User(name.toString(),ket_qua,startTime.toString(),endTime.toString())
//                var db = Database(context)
//                var us = db.insertUser(user)
//
                val intent = Intent(this, BangDiem::class.java)
                intent.putExtra("ketqua", ket_qua.toString())
                intent.putExtra("name", name.toString())
                startActivity(intent)
            }else{
                bai_toan_khac()
                d.setBackgroundColor(Color.WHITE)
                a.setBackgroundColor(Color.WHITE)
                b.setBackgroundColor(Color.WHITE)
                c.setBackgroundColor(Color.WHITE)
                sl_cau_hoi.setText(so_luong.toString()+"/10")
                val array_length = back_images.size
                val random_length = Random.nextInt(array_length.toInt())
                screenView.setBackgroundResource(back_images[random_length])
            }

        }

    }
}