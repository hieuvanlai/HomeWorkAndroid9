package com.example.hieuv.kimbinhmai.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hieuv on 6/17/2017.
 */

public class DatabaseHandle {
    //Create instance MyDatabase
    private Mydatabase mydatabase;

    public DatabaseHandle(Context  context) {
        this.mydatabase = new Mydatabase(context);
    }
    //    Create instance DatabaseHandle
    private static DatabaseHandle instance;

    public static DatabaseHandle getInstance(Context context){
        if (instance==null){
            instance=new DatabaseHandle(context);
        }
        return instance;
    }
    private SQLiteDatabase storyDatabase;
    //getList story
    public List<StoryModel> getListStory(){
        storyDatabase = mydatabase.getReadableDatabase();

        List<StoryModel> storyModelList = new ArrayList<>();

        Cursor cursor = storyDatabase.rawQuery("SELECT * FROM tbl_short_story", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;
            StoryModel storyModel = new StoryModel(id,image,title,description,content,author,bookmark);
            storyModelList.add(storyModel);
            cursor.moveToNext();
        }
        return storyModelList;


    }
    public List<StoryModel> getConten(int iD){
        storyDatabase = mydatabase.getReadableDatabase();

        List<StoryModel> storyModelList = new ArrayList<>();

        Cursor cursor = storyDatabase.rawQuery("SELECT * FROM tbl_short_story where id=" +iD+
                "", null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;
            StoryModel storyModel = new StoryModel(id,image,title,description,content,author,bookmark);
            storyModelList.add(storyModel);
            cursor.moveToNext();
        }
        return storyModelList;


    }

}
