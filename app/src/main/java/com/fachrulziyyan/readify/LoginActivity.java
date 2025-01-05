package com.fachrulziyyan.readify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi View
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnBatal = findViewById(R.id.btnBatal);
        TextView tvRegister = findViewById(R.id.tvRegister);

        // Aksi Login
        btnLogin.setOnClickListener(v -> validateLogin());

        // Aksi Batal
        btnBatal.setOnClickListener(v -> {
            etUsername.setText("");
            etPassword.setText("");
        });

        // Aksi Register
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void validateLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showPopup("Mohon isi username dan password terlebih dahulu.", false);
        } else {
            // Simpan username ke SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("UserPrefs", MODE_PRIVATE).edit();
            editor.putString("username", username);
            editor.apply();

            showPopup("Login berhasil! Selamat datang di Readify.", true);
        }
    }

    private void showPopup(String message, boolean navigateToTabActivity) {
        // Menampilkan popup dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    if (navigateToTabActivity) {
                        Intent intent = new Intent(LoginActivity.this, TabActivity.class);
                        startActivity(intent);
                        finish(); // Menutup LoginActivity agar tidak bisa kembali ke halaman login
                    }
                })
                .create()
                .show();
    }
}
