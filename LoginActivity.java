package com.example.baitap_tuan6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.baitap_tuan6.models.User;

import com.example.baitap_tuan6.models.User;


public class LoginActivity extends AppCompatActivity{
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void setupClickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (validateInput(username, password)) {
                    // Demo login - in real app, you'd verify credentials
                    if (username.equals("admin") && password.equals("123456")) {
                        User user = new User(
                                "khanhts",
                                "khanhts@example.com",
                                "Trần Sỹ Khánh",
                                "0987-654-321",
                                "20/03/2024"
                        );

                        navigateToProfile(user);
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Invalid credentials! Use: admin/123456",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validateInput(String username, String password) {
        if (username.isEmpty()) {
            etUsername.setError("Please enter username");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Please enter password");
            return false;
        }
        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return false;
        }
        return true;
    }

    private void navigateToProfile(User user) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("USER_DATA", user);
        startActivity(intent);
        finish();
    }
}

