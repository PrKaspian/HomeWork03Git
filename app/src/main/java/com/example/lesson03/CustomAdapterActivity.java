package com.example.lesson03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity {
    public static final String KEY_USER = "user";
    private RecyclerView rvContacts;
    private List<User> users;
    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        rvContacts = findViewById(R.id.rvContacts);
        UserDB.write();
        users = UserDB.getAll();
        adapter = new UserAdapter(this, R.layout.item_contact, users);
        rvContacts.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );
        rvContacts.setLayoutManager(layoutManager);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }




}