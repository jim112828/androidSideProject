package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    private String contactName, contactNumber;
    private TextView contactTV, nameTV;
    private ImageView contactIV, callIV, messageIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        contactName = getIntent().getStringExtra("name");
        contactNumber= getIntent().getStringExtra("contact");

        nameTV = findViewById(R.id.idTVName);
        contactIV = findViewById(R.id.idIVContact);
        contactTV = findViewById(R.id.idTVPhone);
        callIV = findViewById(R.id.idIVCall);
        messageIV = findViewById(R.id.idIVMessage);
        callIV.setOnClickListener(v -> makeCall(contactNumber));

        messageIV.setOnClickListener( v -> sendMessage(contactNumber) );

    }

    private void sendMessage(String contactNumber) {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+ contactNumber));
        intent.putExtra("sms_body", "Enter your Message");
        startActivity(intent);

    }

    private void makeCall(String contactNumber) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ contactNumber));

        if (ActivityCompat.checkSelfPermission(ContactDetailActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }


        startActivity(callIntent);
    }


}