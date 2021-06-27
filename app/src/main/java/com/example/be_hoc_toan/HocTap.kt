package com.example.be_hoc_toan


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.math.sin
import kotlin.random.Random
import net.objecthunter.exp4j.ExpressionBuilder


class HocTap : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hoctap)

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
        val thong_bao = findViewById<TextView>(R.id.thong_bao_kq)
        val pheptinh = findViewById<TextView>(R.id.pheptinh)



        fun bai_toan_khac(){
            // random ra 2 số có giới hạn từ 0 -> 100
            // [4,5]

            val randomValues = List(2) { Random.nextInt(0, 100) }
            // + - * /
            val toan_tu = arrayOf("+","-","*","/")

            val random_toan_tu = Random.nextInt(0,3)
            println(toan_tu[2])

            var pt = randomValues[0].toString()+toan_tu[random_toan_tu]+randomValues[1].toString()

            pheptinh.setText(pt)

            // a b c d
            // random ngẫu nhiên ra 1 vị trí đúng trong 4 đáp án đó
            // tao ra 1 mãng kết quả [0,0,0,0]
            // 2
            // [0,0,64,0]
            // [62,63,64,65]
            // cho 1 vòng for chạy qua cái mãng rồi mình sẽ set value cho từng casai button

            val dap_an: IntArray = intArrayOf(0, 0, 0, 0)
            val vi_tri_dap_an_dung = Random.nextInt(0,3)

            // tính toán kết quả dựa vào phép tính được random ra
            val input = ExpressionBuilder(pheptinh.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong() // kq kiểu int
            // 62 ,63, 64, 65
            dap_an[vi_tri_dap_an_dung] = longOutput.toInt()

            // tạo ra vị trí random các đáp án
            for (i in 0..3) {
                if(i!=vi_tri_dap_an_dung){
                    dap_an[i] = longOutput.toInt()-vi_tri_dap_an_dung+i
                }
            }

            // gán giá trị cho các button
            a.setText(dap_an[0].toString())
            b.setText(dap_an[1].toString())
            c.setText(dap_an[2].toString())
            d.setText(dap_an[3].toString())

            // bắt sự kiện click để check đáp án
            val thong_bao_dung = arrayOf("Giỏi quá bé ơi","Xuất xắc","Đúng rồi")
            val thong_bao_sai = arrayOf("Sai rồi","Thử lại nhé","Gần đúng")
            a.setOnClickListener{
                val kq_truyen_vao = a.text.toString()
                if(kq_truyen_vao == longOutput.toString() ){
                    val vi_tri_thong_bao_dung = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_dung[vi_tri_dap_an_dung])

                }
                else{
                    val vi_tri_thong_bao_sai = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao_sai])

                }
            }
            b.setOnClickListener{
                val kq_truyen_vao = b.text.toString()
                if(kq_truyen_vao == longOutput.toString() ){
                    val vi_tri_thong_bao_dung = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_dung[vi_tri_dap_an_dung])

                }
                else{
                    val vi_tri_thong_bao_sai = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao_sai])

                }
            }
            c.setOnClickListener{
                val kq_truyen_vao = c.text.toString()
                if(kq_truyen_vao == longOutput.toString() ){
                    val vi_tri_thong_bao_dung = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_dung[vi_tri_dap_an_dung])

                }
                else{
                    val vi_tri_thong_bao_sai = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao_sai])

                }

            }
            d.setOnClickListener{
                val kq_truyen_vao = d.text.toString()
                if(kq_truyen_vao == longOutput.toString() ){
                    val vi_tri_thong_bao_dung = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_dung[vi_tri_dap_an_dung])

                }
                else{
                    val vi_tri_thong_bao_sai = Random.nextInt(0,2)
                    thong_bao.setText(thong_bao_sai[vi_tri_thong_bao_sai])

                }

            }

        }

        bai_toan_khac()

        next.setOnClickListener{
           bai_toan_khac()

        }











    }
}