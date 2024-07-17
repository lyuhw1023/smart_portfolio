package com.example.smartportfolio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context): SQLiteOpenHelper(context, "testdb", null, 1){
    //db 저장
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table CONTACT_TB(" +
                "_id integer primary key autoincrement," +
                "contact not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}