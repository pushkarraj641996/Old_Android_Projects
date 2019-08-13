package com.doselect.mycourseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.doselect.mycourseapp.DBHelper.Course;

/**
 * Created by deeptis on 23-04-2017.
 */

public class CourseDB {

    // Database fields
    private DBHelper dbHelper;
    private String[] COURSE_TABLE_COLUMNS = { DBHelper.Course_Id, DBHelper.Course_NAME };
    private SQLiteDatabase database;

    public CourseDB(Context context) {

      dbHelper = new DBHelper(context);
    }

    // Open the Connection
    public void open() throws SQLException {
       database = dbHelper.getWritableDatabase();
    }

    // Close the Connection
    public void close() {
        dbHelper.close();
    }

    // Adding record in database
    public Course addCourse(String name) {

        ContentValues values = new ContentValues();

        values.put(DBHelper.Course_NAME, name);

        long courseId = database.insert(Course, null, values);

        // now that the student is created return it ...
        Cursor cursor = database.query(Course,
                COURSE_TABLE_COLUMNS, DBHelper.Course_Id + " = "
                        + courseId, null, null, null, null);

        cursor.moveToFirst();

        Course newComment = parseCourse(cursor);
        cursor.close();
        return newComment;
    }



    // Getting values from database
    public List getAllCourse() {
        List listCourse = new ArrayList();

        Cursor cursor = database.query(Course,
                COURSE_TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Course c = parseCourse(cursor);
            listCourse.add(c);
            cursor.moveToNext();
        }

        cursor.close();
        return listCourse;
    }

    private Course parseCourse(Cursor cursor) {
        Course courseinfo = new Course();
        courseinfo.setId((cursor.getInt(0)));
        courseinfo.setName(cursor.getString(1));
        return courseinfo;
    }
    // Deleteing Record from the database
    public void deleteCourse(Course comment) {
        long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(Course, DBHelper.Course_Id
                + " = " + id, null);
    }


}
