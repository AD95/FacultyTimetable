package edu.msrit.facultytimetable;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class Table extends AppCompatActivity {

    TextView m1,m2,m3,m4,m5,m6,m7,m8,t1,t2,t3,t4,t5,t6,t7,t8,w1,w2,w3,w4,w5,w6,w7,w8,th1,th2,th3,th4,th5,th6,th7,th8,f1,f2,f3,f4,f5,f6,f7,f8,s1,s2,s3,s4,s5,s6,s7,s8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        String sem = getIntent().getStringExtra("sem");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        m1 = (TextView) findViewById(R.id.textView20);
        m2 = (TextView) findViewById(R.id.textView21);
        m3 = (TextView) findViewById(R.id.textView22);
        m4 = (TextView) findViewById(R.id.textView23);
        m5 = (TextView) findViewById(R.id.textView24);
        m6 = (TextView) findViewById(R.id.textView25);
        m7 = (TextView) findViewById(R.id.textView26);
        m8 = (TextView) findViewById(R.id.textView27);
        t1 = (TextView) findViewById(R.id.textView29);
        t2 = (TextView) findViewById(R.id.textView30);
        t3 = (TextView) findViewById(R.id.textView31);
        t4 = (TextView) findViewById(R.id.textView32);
        t5 = (TextView) findViewById(R.id.textView33);
        t6 = (TextView) findViewById(R.id.textView34);
        t7 = (TextView) findViewById(R.id.textView35);
        t8 = (TextView) findViewById(R.id.textView36);
        w1 = (TextView) findViewById(R.id.textView38);
        w2 = (TextView) findViewById(R.id.textView39);
        w3 = (TextView) findViewById(R.id.textView40);
        w4 = (TextView) findViewById(R.id.textView41);
        w5 = (TextView) findViewById(R.id.textView42);
        w6 = (TextView) findViewById(R.id.textView43);
        w7 = (TextView) findViewById(R.id.textView44);
        w8 = (TextView) findViewById(R.id.textView45);
        th1 = (TextView) findViewById(R.id.textView47);
        th2 = (TextView) findViewById(R.id.textView48);
        th3 = (TextView) findViewById(R.id.textView49);
        th4 = (TextView) findViewById(R.id.textView50);
        th5 = (TextView) findViewById(R.id.textView51);
        th6 = (TextView) findViewById(R.id.textView52);
        th7 = (TextView) findViewById(R.id.textView53);
        th8 = (TextView) findViewById(R.id.textView54);
        f1 = (TextView) findViewById(R.id.textView56);
        f2 = (TextView) findViewById(R.id.textView57);
        f3 = (TextView) findViewById(R.id.textView58);
        f4 = (TextView) findViewById(R.id.textView59);
        f5 = (TextView) findViewById(R.id.textView60);
        f6 = (TextView) findViewById(R.id.textView61);
        f7 = (TextView) findViewById(R.id.textView62);
        f8 = (TextView) findViewById(R.id.textView63);
        s1 = (TextView) findViewById(R.id.textView65);
        s2 = (TextView) findViewById(R.id.textView66);
        s3 = (TextView) findViewById(R.id.textView67);
        s4 = (TextView) findViewById(R.id.textView68);
        s5 = (TextView) findViewById(R.id.textView69);
        s6 = (TextView) findViewById(R.id.textView70);
        s7 = (TextView) findViewById(R.id.textView71);
        s8 = (TextView) findViewById(R.id.textView72);
        DBHelper dbHelper = new DBHelper(this, null, 1);
        ArrayList arrayList = new ArrayList<String>();
        if (dbHelper.fetch("9", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Monday");
                m1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Monday");
                m2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Monday");
                m3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Monday");
                m4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Monday");
                m5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Monday");
                m6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Monday");
                m7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Monday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Monday");
                m8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("9", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Tuesday");
                t1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Tuesday");
                t2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Tuesday");
                t3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Tuesday");
                t4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Tuesday");
                t5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Tuesday");
                t6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Tuesday");
                t7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Tuesday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Tuesday");
                t8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("9", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Wednesday");
                w1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Wednesday");
                w2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Wednesday");
                w3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Wednesday");
                w4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Wednesday");
                w5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Wednesday");
                w6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Wednesday");
                w7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Wednesday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Wednesday");
                w8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }

        if (dbHelper.fetch("9", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Thursday");
                th1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Thursday");
                th2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Thursday");
                th3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Thursday");
                th4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Thursday");
                th5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Thursday");
                th6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Thursday");
                th7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Thursday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Thursday");
                th8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }

        if (dbHelper.fetch("9", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Friday");
                f1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Friday");
                f2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Friday");
                f3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Friday");
                f4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Friday");
                f5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Friday");
                f6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Friday");
                f7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Friday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Friday");
                f8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }

        if (dbHelper.fetch("9", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("9", sem, "Saturday");
                s1.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("10", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("10", sem, "Saturday");
                s2.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("11", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("11", sem, "Saturday");
                s3.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("12", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("12", sem, "Saturday");
                s4.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("13", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("13", sem, "Saturday");
                s5.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("14", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("14", sem, "Saturday");
                s6.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("15", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("15", sem, "Saturday");
                s7.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
        if (dbHelper.fetch("16", sem, "Saturday") != null) {
            try{
                arrayList = dbHelper.fetch("16", sem, "Saturday");
                s8.setText(arrayList.get(0) + "\n" + arrayList.get(1));
            }catch(Exception e){
            }
        }
    }


}
