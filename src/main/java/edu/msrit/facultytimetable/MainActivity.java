package edu.msrit.facultytimetable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name,pass;
    DBHelperAdmin db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DBHelperAdmin(this,null,1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        findViewById(R.id.imageButton3).setOnClickListener(this);
        findViewById(R.id.textView5).setOnClickListener(this);    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch (id){
            case R.id.button:
                if(name.getText().toString().equals("admin")&&pass.getText().toString().equals("admin")) {
                    intent = new Intent(getApplicationContext(), Admin.class);
                    startActivity(intent);
                }
                else if(db.fetchRow(name.getText().toString())!=null) {
                    if (db.fetchRow(name.getText().toString()).equals(pass.getText().toString())) {
                        intent = new Intent(getApplicationContext(), User.class);
                        startActivity(intent);
                    }
                }
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
