package com.gouda.vivek.dbintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import data.DatabaseHandler;
import model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //count

        Log.d("DB count : ", String.valueOf(db.getContactCounts()));

        //Insert contacts
//        Log.d("Insert : "," Inserting a contact");
//        db.addContact(new Contact("Vivek","9921347115"));
//        db.addContact(new Contact("Nilesh","8983731583"));
//        db.addContact(new Contact("Akash","5896348963"));
//        db.addContact(new Contact("Ameya","9245689756"));

        //Read all contacts
        Log.d("Read : "," Reading all contacts");
        List<Contact> contactList = db.getAllContacts();
//
//        //Get one contact
//        Contact oneContact = db.getContact(10);
//        oneContact.setName("Vivek Gouda");
//        oneContact.setPhoneNumber("00000000000");
//
//        //update contact
//        int newContact = db.updateContacts(oneContact);
//
//        Log.d("One Contact : "," Updated Row "+String.valueOf(newContact)+" Name : "+oneContact.getName()+" Phone Number : "+oneContact.getPhoneNumber());

//        db.deleteContact(oneContact);
//        //Get all contacts
        for (Contact c : contactList) {
            String log = "ID : "+c.getId()+" Name : "+c.getName()+" Phone Number : "+c.getPhoneNumber();
            Log.d("Name : ",log);
        }


    }
}
