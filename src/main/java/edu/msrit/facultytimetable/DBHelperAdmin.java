package edu.msrit.facultytimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by AD95 on 24-04-2017.
 */

public class DBHelperAdmin extends SQLiteOpenHelper {

    DBHelperAdmin(Context ctx, SQLiteDatabase.CursorFactory factory, int version){
        super(ctx,"tt.db", factory,version);
        File folder = new File(Environment.getExternalStorageDirectory().getPath());
        folder.mkdirs();
        File database = new File(Environment.getExternalStorageDirectory().getPath(), "tt.db");
        if(!database.exists())
            try {
                database.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        SQLiteDatabase.openOrCreateDatabase(database, factory);
        onCreate(getWritableDatabase());
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + "admin" +
                " ("+
                "name text,"+
                "password text,"+
                "PRIMARY KEY(name)"+
                ");");
    }

    public void createRow(ContentValues values, Context c){
        String exists= rowExists(values.get("name").toString());
        if(exists == null)
            getWritableDatabase().insert("admin" , null, values);
        else{
            getWritableDatabase().update("admin", values, "name='" + values.get("name") + "'", null);
            Toast.makeText(c, "Student slot overwritten!", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(String n){
            getWritableDatabase().delete("admin", "name = '" + n + "'", null);
    }

    public String rowExists(String name){
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + "admin" + " WHERE name = '" + name + "'", null);
        if(c!=null){
            if(c.moveToFirst()){
                return c.getString(0);
            }
            else
                return null;
        }
        c.close();
        return null;
    }

    public String fetchRow(String name){
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "+ "admin" + " WHERE name = '" + name + "'", null);
        String list = new String();
        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    list = c.getString(1);
                }while (c.moveToNext());
            }
        }
        if (c != null) {
            c.close();
        }
        if(c==null)
            return null;
        return list;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
