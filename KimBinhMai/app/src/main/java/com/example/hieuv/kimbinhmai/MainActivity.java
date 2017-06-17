package com.example.hieuv.kimbinhmai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hieuv.kimbinhmai.databases.DatabaseHandle;
import com.example.hieuv.kimbinhmai.databases.StoryModel;

public class MainActivity extends AppCompatActivity {
    private ListView listView;


    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.lv_story);
        StoryAdapter arrayAdapter = new StoryAdapter(this,R.layout.item_list_story,DatabaseHandle.getInstance(this).getListStory());

        listView.setAdapter(arrayAdapter);


    }
}
