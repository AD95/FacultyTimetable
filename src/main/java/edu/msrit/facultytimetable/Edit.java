package edu.msrit.facultytimetable;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Insert your slot");
        final Spinner sem=(Spinner) findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8};
        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        sem.setAdapter(adapter);

        final Spinner am=(Spinner) findViewById(R.id.spinner2);
        Integer[] items1 = new Integer[]{9,10,11,12};
        final ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items1);
        am.setAdapter(adapter1);

        final Spinner day=(Spinner) findViewById(R.id.Day);
        String[] items9 = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        final ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items9);
        day.setAdapter(adapter9);

        final ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);

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
        final EditText name,sub,room;
        name = (EditText)findViewById(R.id.Name);
        sub = (EditText)findViewById(R.id.Subject);

        Button submit,reset;
        submit = (Button)findViewById(R.id.Insert);
        reset = (Button)findViewById(R.id.Reset);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(getApplicationContext(),null,1);
                ContentValues values = new ContentValues();
                values.put("name", String.valueOf(name.getText()));
                values.put("subject", String.valueOf(sub.getText()));
                values.put("semester", sem.getSelectedItem().toString());
                values.put("day", day.getSelectedItem().toString());
                String time1 = null;
                Log.d("he",am.getSelectedItem().toString());
                if(toggleButton.isChecked()){
                    time1 = (am.getSelectedItem().toString());
                }
                else{
                    time1 = (String.valueOf(Integer.parseInt(am.getSelectedItem().toString())+12));
                }
                values.put("time", time1);
                dbHelper.createRow(values, getApplicationContext());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                sub.setText("");
                day.setAdapter(adapter9);
                sem.setAdapter(adapter);
                toggleButton.setChecked(true);
            }
        });
    }

}
