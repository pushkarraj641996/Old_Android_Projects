package com.doselect.mycourseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deeptis on 23-04-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // Table
    public static final String Course = "Courses";
    //Column
    public static final String Course_Id = "_id";
    public static final String Course_NAME = "_name";
// Database
    private static final String DATABASE_NAME = "Students.db";
    private static final int DATABASE_VERSION = 1;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table " + Course
            + "(" + Course_Id + " integer primary key autoincrement, "
            + Course_NAME + " text not null);";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Course);
        onCreate(db);
    }

}
