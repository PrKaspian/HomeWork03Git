package com.example.lesson03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListContactActivity extends AppCompatActivity {

    private ListView lvContacts;
    private List<Contact> contacts;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        lvContacts = findViewById(R.id.lvContacts);
//        String[]themes = {"dark","light", "android"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, themes);
//        lvContacts.setAdapter(adapter);

        contacts = ContactDB.getAll();

        List<Map<String, String>> data =new ArrayList<>();
        Map<String, String> map = null;

//        map = new HashMap<>();
//        map.put("name", "Ivan Ivanov");
//        map.put("phone", "097-333-33-33");
//        data.add(map);
//
//        map = new HashMap<>();
//        map.put("name", "Petr Petrov");
//        map.put("phone", "097-444-44-44");
//        data.add(map);

        for (Contact contact : contacts) {
            map = new HashMap<>();
            map.put("name", contact.getFullName());
            map.put("phone", contact.getPhone());
            data.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                android.R.layout.two_line_list_item,
                new String[]{"name", "phone"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        lvContacts.setAdapter(adapter);
        lvContacts.setOnItemClickListener((parent, view, position, id) -> {
            Contact selectedContact = contacts.get(position);
            String phone = selectedContact.getPhone();
            Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
        });

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(this, CustomAdapterActivity.class));
        });
    }
}