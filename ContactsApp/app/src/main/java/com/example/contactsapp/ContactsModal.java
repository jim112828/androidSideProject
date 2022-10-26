package com.example.contactsapp;

import java.util.SplittableRandom;

public class ContactsModal {
    private  String userName;
    private String contactNumber;

    public ContactsModal(String userName, String contactNumber){
        this.userName = userName;
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String setUserName(String userName){
        this.userName = userName;
        return  userName;
    }





}
