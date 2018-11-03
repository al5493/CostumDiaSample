package com.videxedge.costumdiasample;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    LinearLayout mydialog;
    EditText eTName, eTPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        mydialog=(LinearLayout) getLayoutInflater().inflate(R.layout.my_dialog,null);
        eTName = (EditText) mydialog.findViewById(R.id.eTname);
        eTPass = (EditText) mydialog.findViewById(R.id.eTpass);

        adb=new AlertDialog.Builder(this);

        adb.setView(mydialog);
        mydialog.setBackgroundColor(Color.YELLOW);
        adb.setTitle("Identification");
        adb.setMessage("Please enter your name & password:");
        adb.setPositiveButton("Enter",myclick);
        adb.setNegativeButton("Cancel",myclick);
        adb.show();
    }

    DialogInterface.OnClickListener myclick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                String str1 = eTName.getText().toString();
                String str2 = eTPass.getText().toString();
                Toast.makeText(MainActivity.this, "Name: "+str1+" Password: "+str2, Toast.LENGTH_SHORT).show();
            }
            if (which == DialogInterface.BUTTON_NEGATIVE) {
                dialog.cancel();
            }
        }
    };
}
