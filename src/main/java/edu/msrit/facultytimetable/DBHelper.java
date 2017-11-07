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
import java.util.ArrayList;

/**
 * Created by AD95 on 24-04-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context ctx, SQLiteDatabase.CursorFactory factory, int version){
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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + "timetable" +
                " ("+
                "name text,"+
                "subject text,"+
                "semester text,"+
                "day text,"+
                "time text"+
                ");");
    }

    public void createRow(ContentValues values, Context c){
        if(fetch(values.getAsString("time"),values.getAsString("semester"),values.getAsString("day")) == null) {
            getWritableDatabase().insert("timetable", null, values);
            Toast.makeText(c, "Added!", Toast.LENGTH_SHORT).show();
        }
        else{
            getWritableDatabase().update("timetable", values, "time='" + values.get("time") + "' AND day ='" + values.get("day") + "' AND semester = '" + values.get("semester") + "'", null);
            Toast.makeText(c, "Time slot overwritten!", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<String> fetch(String time, String sem, String day){
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "+ "timetable" + " WHERE time = '" + time + "' AND semester='"+sem+ "' AND day='"+day+"'", null);
        ArrayList<String> list = null;
        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    list=new ArrayList<>();
                    for(int i=0; i<4; i++)
                        list.add(c.getString(i));
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
