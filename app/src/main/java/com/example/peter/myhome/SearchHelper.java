package com.example.peter.myhome;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/11/21.
 */

public abstract class SearchHelper extends SQLiteOpenHelper {
    public SearchHelper(Context context){
        super(context, "Property_Address.db",null,1);
    }

    public void OnCreate(SQLiteDatabase db){
//        db.execSQL("create table Property_Address(Property_id,Street char(45),City char(45),Country char(45),PostalCode char(45))");
    }

    public SearchResult findResult(String location){
        String query =null;
        //"Select * From " + Property_Address + "Where" + Street/city/country = location;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        SearchResult result = new SearchResult();

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            result.setStree(cursor.getString(1));
            result.setId(Integer.parseInt(cursor.getString(0)));
            result.setPostalCode(cursor.getString(4));
            result.setCountry(cursor.getString(3));
            result.setCity(cursor.getString(2));
        }else {
            result = null;
        }
        db.close();
        return result;
    }

}
