package edu.msrit.facultytimetable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class User extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("User Access");
        ImageButton create = (ImageButton)findViewById(R.id.imageButton);
        TextView create1 = (TextView)findViewById(R.id.textView4);
        ImageButton view = (ImageButton)findViewById(R.id.imageButton2);
        TextView view1 = (TextView)findViewById(R.id.textView3);
        findViewById(R.id.textView5).setOnClickListener(this);
        findViewById(R.id.imageButton3).setOnClickListener(this);
        create.setOnClickListener(this);
        create1.setOnClickListener(this);
        view.setOnClickListener(this);
        view1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        Intent intent;
        switch (id){
            case R.id.imageButton:
            case R.id.textView4:
                intent = new Intent(getApplicationContext(), Edit.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
            case R.id.textView3:
                intent = new Intent(getApplicationContext(), Find.class);
                startActivity(intent);
                break;
            case R.id.imageButton3:
            case R.id.textView5:
                LayoutInflater li = LayoutInflater.from(this);
                View promptsView = li.inflate(R.layout.my_dialog_layout, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setView(promptsView);
                alertDialogBuilder.setTitle("Select Semester");
                final Spinner mSpinner= (Spinner) promptsView
                        .findViewById(R.id.spinner4);
                Integer[] items = new Integer[]{1,2,3,4,5,6,7,8};
                final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
                mSpinner.setAdapter(adapter);
                alertDialogBuilder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Table.class);
                        intent.putExtra("sem",mSpinner.getSelectedItem().toString());
                        startActivity(intent);
                    }
                });
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
        }
    }
}
