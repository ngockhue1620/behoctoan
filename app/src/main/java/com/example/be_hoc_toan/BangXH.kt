package com.example.be_hoc_toan

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.bangxephang.*
import kotlinx.android.synthetic.main.user_row.view.*

private  lateinit var  sqlLiteHelper: SQLiteOpenHelper
private  lateinit var recyclerView: RecyclerView

class BangXH : AppCompatActivity() {
    val adapter=GroupAdapter<GroupieViewHolder>()
    private lateinit var arrUser: ArrayList<String>
    private lateinit var db:Database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bangxephang)
        val context = this
        db = Database(context)
        initRecycleVIew()
        tieptup.setOnClickListener {
            val intent = Intent(this, NhapTen::class.java)

            startActivity(intent)
        }
    }
    private fun initRecycleVIew(){
        var listUs = db.getTopUser()
        Log.d("lengthListUs",listUs.size.toString())
        listUs.forEach {
            adapter.add(UserRowItem(it))
        }

        rcc_user.adapter = adapter
        rcc_user.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))


    }


}
class UserRowItem(val user:User): Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.user_row
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val itemView=viewHolder.itemView
        itemView.textView_name_user_row.text=user.Name
        itemView.tv_point_user_row.text=user.Score.toString()

        itemView.endTime.text=user.Time
    }

}