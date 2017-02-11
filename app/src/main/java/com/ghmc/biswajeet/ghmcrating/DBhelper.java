package com.ghmc.biswajeet.ghmcrating;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by biswajeet on 11/2/17.
 */

public class DBhelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "GHMC";



    // Common column names
    private static final String KEY_LOC =  "LOCALITY";
    private static final String TABLE_NAME = "GHMCRATE";

    // NOTES Table - column nmaes
    private static final String KEY_RATE = "RATING";
    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_NAME+ "(" + KEY_LOC + " TEXT ," + KEY_RATE + " INTEGER"+ ")";
    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);
        Log.d("Databaseoncreate","created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addArea(Dbmodel dbmodel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LOC, dbmodel.getLocality());
        values.put(KEY_RATE, dbmodel.getRating());
        db.insert(TABLE_NAME,null,values);
        db.close();
        }
    public Dbmodel getRate(String KEY_LOC) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_LOC,
                        KEY_RATE}, KEY_LOC + "=?",
                new String[] { String.valueOf(KEY_LOC) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Dbmodel model = new Dbmodel(cursor.getString(0), Integer.parseInt(cursor.getString(1)));
        Log.d("Getrate",model.getLocality());
        // return contact
        return model;
    }
}
