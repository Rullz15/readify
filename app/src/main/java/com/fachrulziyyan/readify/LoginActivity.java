package com.fachrulziyyan.readify;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private ImageView ivShowHidePassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi View
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        ivShowHidePassword = findViewById(R.id.ivShowHidePassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnBatal = findViewById(R.id.btnBatal);
        TextView tvRegister = findViewById(R.id.tvRegister);

        // Menangani aksi Tampilkan/Sembunyikan Password
        ivShowHidePassword.setOnClickListener(v -> {
            if (isPasswordVisible) {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                ivShowHidePassword.setImageResource(R.drawable.show);
            } else {
                etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                ivShowHidePassword.setImageResource(R.drawable.hide);
            }
            isPasswordVisible = !isPasswordVisible;
            etPassword.setSelection(etPassword.length());
        });

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

    private void showPopup(String message, boolean navigateToMain) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Lanjutkan", (dialog, id) -> {
                    if (navigateToMain) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    dialog.dismiss();
                })
                .create()
                .show();
    }

    private void validateLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showPopup("Mohon isi username dan password terlebih dahulu.", false);
        } else { // Contoh data hardcoded
            // Simpan data username ke SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("UserPrefs", MODE_PRIVATE).edit();
            editor.putString("username", username);
            editor.apply(); // Simpan perubahan ke SharedPreferences

            showPopup("Login berhasil! Selamat datang di Readify.", true);
        }
    }

}
