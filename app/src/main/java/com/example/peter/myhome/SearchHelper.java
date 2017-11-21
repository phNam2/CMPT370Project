package com.example.peter.myhome;

import android.content.Context;
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
        db.execSQL("create table Property_Address(Property_id,Street char(45),City char(45),Country char(45),PostalCode char(45))");
    }

}
