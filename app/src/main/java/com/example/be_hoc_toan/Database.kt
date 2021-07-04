package com.example.be_hoc_toan

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "behoctoan"
val TABLE_NAME = "Users"
val COL_NAME ="Name"
val COL_SCORE ="Score"
val COL_START_TIME = "StartTime"
val COL_END_TIME = "EndTime"
val COL_ID = "id"
class Database (context : Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "create table"+ TABLE_NAME+"(" +
                COL_ID + "integer primary key autoincrement," +
                COL_NAME + "nvarchar(255)," +
                COL_SCORE + "int," +
                COL_START_TIME + "datetime" +
                COL_END_TIME + "datetime";
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertUser(user : User): Long {
        val db = writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.Name)
        cv.put(COL_SCORE,user.Score)
        cv.put(COL_START_TIME,user.startTime)
        cv.put(COL_END_TIME,user.endTime)
        val result = db.insert(TABLE_NAME,null,cv)
        return result
    }
    fun getTopUser(): List<User>? {
        val userList: MutableList<User> = ArrayList()
        val query = "SELECT top(5) * FROM$TABLE_NAME"
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        while (cursor.isAfterLast() === false) {
            val user = User(
                cursor.getString(0),
                cursor.getInt(1),
                cursor.getString(2),
                cursor.getString(3)
            )
            userList.add(user)
            cursor.moveToNext()
        }
        return userList
    }

}