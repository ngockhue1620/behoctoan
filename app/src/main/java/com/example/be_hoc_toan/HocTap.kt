package com.example.be_hoc_toan


import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random



class HocTap : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hoctap)
        var back_images = arrayOf(R.drawable.anh1,R.drawable.toan2,R.drawable.toan1,R.drawable.toan3,R.drawable.toan4,R.drawable.toan5,R.drawable.toan6,R.drawable.toan7)
        val screenView = findViewById<LinearLayout>(R.id.linear_layout1)
        val back_to_home = findViewById<Button>(R.id.back_to_home)

        back_to_home.setOnClickListener{
            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val a = findViewById<Button>(R.id.A)
        val b = findViewById<Button>(R.id.B)
        val c = findViewById<Button>(R.id.C)
        val d = findViewById<Button>(R.id.D)
        val next = findViewById<Button>(R.id.next)
        val gio_han = findViewById<EditText>(R.id.gioi_han)
        val thong_bao = findViewById<TextView>(R.id.thong_bao_kq)
        val pheptinh = findViewById<TextView>(R.id.pheptinh)
        val dieu_chinh = findViewById<Button>(R.id.dieu_chinh)
        var ket_qua_phep_tinh = 0


        fun bai_toan_khac(){
            thong_bao.setText("")
            val lay_gioi_han = gio_han.text.toString().toInt()
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

            val thong_bao_dung = arrayOf("Giỏi quá bé ơi","Xuất xắc","Đúng rồi","yeee")
            val thong_bao_sai = arrayOf("Sai rồi","Thử lại nhé","Gần đúng","không phải")
            a.setOnClickListener{
                val kq_truyen_vao = a.text.toString()
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    thong_bao.setText(thong_bao_dung[vi_tri_thong_bao])

                }
                else{
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao])
                }
            }
            b.setOnClickListener{
                val kq_truyen_vao = b.text.toString()

                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){


                    thong_bao.setText(thong_bao_dung[vi_tri_thong_bao])
                }
                else{

                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao])
                }
            }
            c.setOnClickListener{
                val kq_truyen_vao = c.text.toString()

                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    thong_bao.setText(thong_bao_dung[vi_tri_thong_bao])

                }
                else{
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao])
                }

            }
            d.setOnClickListener{
                val kq_truyen_vao = d.text.toString()
                if(kq_truyen_vao == ket_qua_phep_tinh.toString() ){
                    thong_bao.setText(thong_bao_dung[vi_tri_thong_bao])

                }
                else{
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao])
                }
            }
        }
        bai_toan_khac()
        next.setOnClickListener{
           bai_toan_khac()
            val array_length = back_images.size
            val random_length = Random.nextInt(array_length.toInt())
            screenView.setBackgroundResource(back_images[random_length])
        }
        dieu_chinh.setOnClickListener {
            bai_toan_khac()
        }











    }
}