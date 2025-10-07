package com.example.baitap_tuan6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.baitap_tuan6.models.User;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnSetting;
    private TextView tvFullName;
    private TextView tvUsername;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvJoinDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
        setupClickListeners();
        displayUserData();
    }

    private void initViews() {
        btnSetting = findViewById(R.id.btnSetting);
        tvFullName = findViewById(R.id.tvFullName);
        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvJoinDate = findViewById(R.id.tvJoinDate);
    }

    private void setupClickListeners() {
        btnSetting.setOnClickListener(v -> navigateToLogin());
    }

    private void displayUserData() {
        User user = (User) getIntent().getSerializableExtra("USER_DATA");
        if (user != null) {
            tvFullName.setText(user.getFullName());
            tvUsername.setText("@" + user.getUsername());
            tvEmail.setText(user.getEmail());
            tvPhone.setText(user.getPhone());
            tvJoinDate.setText(user.getJoinDate());
        } else {
            // Nếu không có data từ login, hiển thị mặc định
            tvFullName.setText("Trần Sỹ Khánh");
            tvUsername.setText("@khanhts");
            tvEmail.setText("khanhts@example.com");
            tvPhone.setText("0987-654-321");
            tvJoinDate.setText("20/03/2024");
        }
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}