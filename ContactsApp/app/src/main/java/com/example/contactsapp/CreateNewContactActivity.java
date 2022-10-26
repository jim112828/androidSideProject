package com.example.contactsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewContactActivity extends AppCompatActivity {

    private EditText nameEdt, phoneEdt,emailEdt;
    private Button addContactEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_contact);
        nameEdt = findViewById(R.id.idEdtName);
        phoneEdt =findViewById(R.id.idEdtPhoneNumber);
        emailEdt = findViewById(R.id.idEdtEmail);
        addContactEdt = findViewById(R.id.idBtnAddContact);

        addContactEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                String phone = nameEdt.getText().toString();
                String email = nameEdt.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(email)){
                    Toast.makeText(CreateNewContactActivity.this,"Please enter the data in all fields. ", Toast.LENGTH_SHORT).show();
                }
                    addContacct(name,phone,email);
            }
        });
    }

    private void addContacct(String name, String phone, String email) {

        Intent contactIntext = new Intent(ContactsContract.Intents.Insert.ACTION);
        contactIntext.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        contactIntext.putExtra(ContactsContract.Intents.Insert.NAME,name);
        contactIntext.putExtra(ContactsContract.Intents.Insert.PHONE,phone);
        contactIntext.putExtra(ContactsContract.Intents.Insert.EMAIL,email);
        startActivityForResult(contactIntext,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){

            if (resultCode == Activity.RESULT_OK){
                Toast.makeText(this,"Contact has been added.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(CreateNewContactActivity.this,MainActivity.class);
                startActivity(i);
            }
            if (requestCode == Activity.RESULT_CANCELED){
                Toast.makeText(this,"Result is canceled",Toast.LENGTH_SHORT).show();
            }
        }


    }
}