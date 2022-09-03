package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnMessage, btnEmail, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnDial =findViewById(R.id.dialbtn);
        btnMessage = findViewById(R.id.messagebtn);
        btnEmail = findViewById(R.id.emailbtn);
        btnShare =findViewById(R.id.sharebtn);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +923111167543"));
                startActivity(iDial);

            }
        });


        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMessage = new Intent(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto:"+Uri.encode("+923142255789")));
                iMessage.putExtra("sms_body","contact asap");
                startActivity(iMessage);
            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"hm005244@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "query");
                iEmail.putExtra(Intent.EXTRA_TEXT,"PLEASE RESOLVE ISSUE");
                startActivity(Intent.createChooser(iEmail, "Email via"));

            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"share with others");
                startActivity(Intent.createChooser(iShare,"Share Via"));

            }
        });






    }
}