package com.example.lesson03;

public class Contact {
    private String fullName;
    private String phone;

    public Contact(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }
}
