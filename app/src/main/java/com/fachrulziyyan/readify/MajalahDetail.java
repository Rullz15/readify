package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MajalahDetail extends AppCompatActivity {

    private ImageView btnBack, ivCover;
    private TextView tvJudul, tvRating, tvPrice, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.majalah_detail);

        // Inisialisasi Views
        btnBack = findViewById(R.id.btnBack);
        ivCover = findViewById(R.id.ivCover);
        tvJudul = findViewById(R.id.tvJudul);
        tvRating = findViewById(R.id.tvRating);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDescription);

        // Tangkap data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("TITLE");
            String rating = intent.getStringExtra("RATING");
            String price = intent.getStringExtra("PRICE");
            String description = intent.getStringExtra("DESCRIPTION");
            int imageResId = intent.getIntExtra("IMAGE_RES_ID", R.drawable.default_cover);

            // Set data ke Views
            tvJudul.setText(title);
            tvRating.setText(rating);
            tvPrice.setText(price);
            tvDescription.setText(description);
            ivCover.setImageResource(imageResId);
        }

        // Listener untuk tombol Back
        btnBack.setOnClickListener(v -> {
            finish(); // Menutup activity ini dan kembali ke activity sebelumnya
        });
    }
}
