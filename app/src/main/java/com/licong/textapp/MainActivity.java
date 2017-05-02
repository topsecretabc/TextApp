package com.licong.textapp;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     Uri uri=Uri.parse("content://com.licong.graduationproject.provider/Textapp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readContacts();

    }
    public  void  readContacts(){

        Cursor cursor =null;
        TextView textView = (TextView) findViewById(R.id.textapp_textview);
        cursor = getContentResolver().query(uri,null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String text = cursor.getString(cursor.getColumnIndex("textapptext"));
                textView.setText(text);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
    }
}
