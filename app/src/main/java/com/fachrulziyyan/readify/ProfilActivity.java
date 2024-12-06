package com.fachrulziyyan.readify;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil); // Pastikan layout benar

        // Ambil data username dari SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String userName = sharedPreferences.getString("username", "Guest"); // Default: Guest jika username tidak ditemukan

        // Set nama pengguna ke TextView
        TextView userNameTextView = findViewById(R.id.userName);
        userNameTextView.setText(userName);

        // Tombol Kembali
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish(); // Tutup aktivitas ini dan kembali ke aktivitas sebelumnya
        });

        // Tombol Chat
        ImageView chatButton = findViewById(R.id.chatButton);
        chatButton.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur chat belum tersedia", Toast.LENGTH_SHORT).show();
        });

        // Tombol Keranjang
        ImageView cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Toast.makeText(this, "Fitur keranjang belum tersedia", Toast.LENGTH_SHORT).show();
        });
    }
}
