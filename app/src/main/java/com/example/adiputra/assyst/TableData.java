package com.example.adiputra.assyst;

import android.provider.BaseColumns;

/**
 * Created by joglo-developer on 3/28/2017.
 */

public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns{
        public static final String LOCATION = "location";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String DATABASE_NAME = "assyst_db";
        public static final String TABLE_NAME = "location_table";
    }
}
