package com.doselect.mycourseapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.List;

public class CourseScreen extends ListActivity {

    private CourseDB courseDBOperation;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_screen);

        courseDBOperation = new CourseDB(this);
        try {

            courseDBOperation.open();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        List values = courseDBOperation.getAllCourse();
        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);



    }
// OnCLick method of Add Course Button
    public void addRecord(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();

        EditText text = (EditText)findViewById(R.id.couseEditText);
        Course stud = courseDBOperation.addCourse(text.getText().toString());

        adapter.add(stud);
        text.setText("");


    }
    // OnCLick method of Delete  Course Button
    public void deleteRecord(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        Course stud = null;

        if (getListAdapter().getCount() > 0) {
            stud = (Course) getListAdapter().getItem(0);
            courseDBOperation.deleteCourse(stud);
            adapter.remove(stud);
        }

    }
    @Override
    protected void onResume() {
        try {
            courseDBOperation.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        courseDBOperation.close();
        super.onPause();
    }
}
