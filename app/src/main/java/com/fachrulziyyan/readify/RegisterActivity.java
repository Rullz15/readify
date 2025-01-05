package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail, inputUser, inputPassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi elemen UI
        inputEmail = findViewById(R.id.inputEmail);
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnBatal = findViewById(R.id.btnBatal);
        TextView tvLogin = findViewById(R.id.tvLogin);

        // Aksi tombol Register
        btnRegister.setOnClickListener(v -> validateAndRegister());

        // Aksi tombol Batal
        btnBatal.setOnClickListener(v -> clearForm());

        // Aksi untuk navigasi ke LoginActivity
        tvLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Memvalidasi input pengguna dan menampilkan dialog jika berhasil.
     */
    private void validateAndRegister() {
        String email = inputEmail.getText().toString().trim();
        String username = inputUser.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            showAlert("Input tidak boleh kosong!", false);
        } else if (!email.endsWith("@gmail.com") || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showAlert("Email yang Anda masukkan tidak valid. Masukkan email dengan benar!", false);
        } else {
            showAlert("Akun Anda sudah berhasil didaftarkan.", true);
        }
    }

    /**
     * Menampilkan dialog pop-up dengan opsi lanjutkan.
     *
     * @param message Pesan yang ingin ditampilkan.
     * @param navigateToLogin Jika true, navigasi ke LoginActivity setelah tombol ditekan.
     */
    private void showAlert(String message, boolean navigateToLogin) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Lanjutkan", (dialog, which) -> {
                    if (navigateToLogin) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        builder.create().show();
    }

    /**
     * Membersihkan form input.
     */
    private void clearForm() {
        inputEmail.setText("");
        inputUser.setText("");
        inputPassword.setText("");
    }
}
