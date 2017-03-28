package com.example.adiputra.assyst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by joglo-developer on 3/28/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ TableData.TableInfo.TABLE_NAME+"("+
            TableData.TableInfo.LOCATION+" TEXT,"+
            TableData.TableInfo.LATITUDE+" TEXT,"+
            TableData.TableInfo.LONGITUDE+" TEXT );";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    public void putInformation(DatabaseOperations dop, String location, String latitude, String longitude){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.LOCATION, location);
        cv.put(TableData.TableInfo.LATITUDE, latitude);
        cv.put(TableData.TableInfo.LONGITUDE, longitude);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations","1 row inserted");
    }

    public Cursor getInformation(DatabaseOperations dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloums = {
                TableData.TableInfo.LOCATION,
                TableData.TableInfo.LATITUDE,
                TableData.TableInfo.LONGITUDE
        };
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME, coloums, null, null, null, null, null);
        return CR;
    }
}
