package edu.msrit.facultytimetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Find extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search");

        final Spinner sem=(Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8};
        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        sem.setAdapter(adapter);

        final Spinner day=(Spinner) findViewById(R.id.Day);
        String[] items9 = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        final ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items9);
        day.setAdapter(adapter9);

        final Spinner am=(Spinner) findViewById(R.id.spinner3);
        Integer[] items1 = new Integer[]{9,10,11,12};
        final ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items1);
        am.setAdapter(adapter1);

        final ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Integer[] items1 = new Integer[]{9,10,11,12};
                    final ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_spinner_item, items1);
                    am.setAdapter(adapter1);
                }
                else {
                    Integer[] items1 = new Integer[]{1,2,3,4};
                    final ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_spinner_item, items1);
                    am.setAdapter(adapter1);
                }
            }
        });
        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        final CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox2);
        Button find = (Button)findViewById(R.id.Find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time1 = null;
                String day1 = null;
                String sem1 = null;
                ArrayList<String> arrayList = new ArrayList<String>();
                DBHelper dbHelper = new DBHelper(getApplicationContext(),null,1);
                TextView textView = (TextView)findViewById(R.id.textView8);
                if(checkBox.isChecked()) {
                    time1 = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
                }
                else
                    time1 = am.getSelectedItem().toString();
                if(checkBox1.isChecked()){
                    day1 = new SimpleDateFormat("dddd").format(Calendar.getInstance().getTime());
                }
                else
                    day1 = day.getSelectedItem().toString();
                    sem1 = sem.getSelectedItem().toString();


                    arrayList = dbHelper.fetch(time1, sem1,day1);
                    if(arrayList==null || arrayList.isEmpty()){
                        textView.setText("Faculty is free now!");
                    }
                    else {
                        if(!arrayList.isEmpty())
                        textView.setText(arrayList.get(0) + " is taking class:\n"+"Sub:"+arrayList.get(1)+", Sem:"+arrayList.get(2)+"\n"+arrayList.get(3)+", Slot:"+String.valueOf(((Integer.parseInt(time1))>12)?(Integer.parseInt(time1)-12)+" PM":(Integer.parseInt(time1))+" AM")+"-"+String.valueOf(((Integer.parseInt(time1)+1)>12)?(Integer.parseInt(time1)+1-12)+" PM":(Integer.parseInt(time1)+1)+" AM"));
                    }
            }
        });

    }

}
