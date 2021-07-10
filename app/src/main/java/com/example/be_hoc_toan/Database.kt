package com.example.be_hoc_toan

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

val DATABASE_NAME = "behoctoan.db"
val TABLE_NAME = "Users"
val COL_NAME ="Name"
val COL_SCORE ="Score"
val COL_START_TIME = "StartTime"
val COL_END_TIME = "EndTime"
val COL_ID = "id"
val COL_TIME ="Time"
class Database (context : Context): SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
//        val createDatabase = " CREATE DATABASE $DATABASE_NAME"
        val createTable = "CREATE TABLE "+ TABLE_NAME+"(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COL_NAME + " TEXT," +
                COL_SCORE + " INT ," +
                COL_START_TIME + " TEXT ," +
                COL_END_TIME + " TEXT ,"+
                COL_TIME + " TEXT )";
//        db?.execSQL(createDatabase)
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(("DROP TABLE IF EXISTS $TABLE_NAME"))
        onCreate(db)
    }
    fun insertUser(user : User): Long {
        val db = writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.Name)
        cv.put(COL_SCORE,user.Score)
        cv.put(COL_START_TIME,user.startTime)
        cv.put(COL_END_TIME,user.endTime)
        cv.put(COL_TIME,user.Time)
        val result = db.insert(TABLE_NAME,null,cv)
        db.close()
        return result
    }
    fun getTopUser(): ArrayList<User> {
        val userList: ArrayList<User> = ArrayList()
        val query = "SELECT  *  FROM $TABLE_NAME ORDER BY Score DESC LIMIT 5  "
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        while (cursor.isAfterLast() === false) {
            var user = User(
                cursor.getString(cursor.getColumnIndex("Name")),
                cursor.getInt(cursor.getColumnIndex("Score")),
                cursor.getString(cursor.getColumnIndex("StartTime")),
                cursor.getString(cursor.getColumnIndex("EndTime")),
                cursor.getString(cursor.getColumnIndex("Time"))
            )
            Log.e("username",user.Name)
            userList.add(user)
            cursor.moveToNext()
        }
        return userList
    }

}