package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hubungkan ID kategori
        View layoutNovel = findViewById(R.id.layoutNovel);
        View layoutKomik = findViewById(R.id.layoutKomik);
        View layoutMajalah = findViewById(R.id.layoutMajalah);
        View layoutPelajaran = findViewById(R.id.layoutPelajaran);
        View profilIcon = findViewById(R.id.profilIcon);

        // Navigasi ke halaman NovelActivity
        layoutNovel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NovelActivity.class);
            startActivity(intent);
        });

        // Navigasi ke halaman KomikActivity
        layoutKomik.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KomikActivity.class);
            startActivity(intent);
        });

        // Navigasi ke halaman MajalahActivity
        layoutMajalah.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MajalahActivity.class);
            startActivity(intent);
        });

        // Navigasi ke halaman PelajaranActivity
        layoutPelajaran.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PelajaranActivity.class);
            startActivity(intent);
        });
        // Tombol Profil
        layoutPelajaran.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PelajaranActivity.class);
            startActivity(intent);
        });
        profilIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
            startActivity(intent);
        });
    }
}
