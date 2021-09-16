package com.example.dell.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    DBHelper helper;
    EditText name,email,branch;
    String namestr,emailst,branchstr;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        email= (EditText) findViewById(R.id.email);
        tv= (TextView) findViewById(R.id.tview);
        branch= (EditText) findViewById(R.id.branch);
        helper=new DBHelper(this);
    }


    public void saveData(View view)
    {
        namestr=name.getText().toString();
        emailst=email.getText().toString();
        branchstr=branch.getText().toString();
        ContentValues values=new ContentValues();
        values.put(DBHelper.COL1,namestr);
        values.put(DBHelper.COL2,emailst);
        values.put(DBHelper.COL3,branchstr);
        long i=helper.insertData(values);
        if (i>0)
            Toast.makeText(this,"values stored in DB "+i,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Values not inserted in DB",Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view)
    {
        Cursor cursor= helper.retrieveData();
        StringBuffer data=new StringBuffer();
        while (cursor.moveToNext())
        {
            data.append(cursor.getString(0)+"\t"+cursor.getString(1)+"\t"+cursor.getString(2));
        }
        tv.setText(data);
    }

}
