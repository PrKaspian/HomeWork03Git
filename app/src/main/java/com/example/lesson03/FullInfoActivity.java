package com.example.lesson03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.lesson03.databinding.ActivityFullinfoBinding;

public class FullInfoActivity extends AppCompatActivity {
    private ActivityFullinfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullinfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = (User) getIntent().getSerializableExtra(CustomAdapterActivity.KEY_USER);
        binding.ivAvatar.setImageResource(user.getAvatar());
        binding.etFirstName.setText(user.getFirstName());
        binding.etLastName.setText(user.getLastName());
        binding.etPhone.setText(user.getPhone());
        binding.etEmail.setText(user.getEmail());

        binding.btnApply.setOnClickListener(view -> {
            user.setFirstName(binding.etFirstName.getText().toString());
            user.setLastName(binding.etLastName.getText().toString());
            user.setPhone(binding.etPhone.getText().toString());
            user.setEmail(binding.etEmail.getText().toString());
            UserDB.setUser(user);
            finish();
        });
    }
}