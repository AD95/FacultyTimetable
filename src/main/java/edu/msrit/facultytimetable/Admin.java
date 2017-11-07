package edu.msrit.facultytimetable;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity implements View.OnClickListener{

    EditText name,pass,name1,pass1;
    DBHelperAdmin db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = new DBHelperAdmin(this,null,1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Admin Access");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        name1 = (EditText) findViewById(R.id.name1);
    }

    @Override
    public void onClick(View vi) {
        int id = vi.getId();
        Intent intent;
        switch (id){
            case R.id.button:
                ContentValues v = new ContentValues();
                if(!name.getText().toString().isEmpty()&&!pass.getText().toString().isEmpty()) {
                    v.put("name", name.getText().toString());
                    v.put("password", pass.getText().toString());
                    db.createRow(v, this);
                    Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                if(!name1.getText().toString().isEmpty() ){
                    if(db.fetchRow(name1.getText().toString())!=null)
                        db.delete(name1.getText().toString());
                Toast.makeText(this, "Deleted!", Toast.LENGTH_SHORT).show();
            }
                break;
        }
    }
}
