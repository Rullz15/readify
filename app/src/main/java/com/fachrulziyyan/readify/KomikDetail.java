package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KomikDetail extends AppCompatActivity {

    private ImageView btnBack, ivCover;
    private TextView tvJudul, tvRating, tvPrice, tvDescription;
    private Button btnBeliSekarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.komik_detail);

        // Inisialisasi komponen UI
        btnBack = findViewById(R.id.btnBack);
        ivCover = findViewById(R.id.ivCover);
        tvJudul = findViewById(R.id.tvJudul);
        tvRating = findViewById(R.id.tvRating);
        tvPrice = findViewById(R.id.tvPrice);
        tvDescription = findViewById(R.id.tvDescription);
        btnBeliSekarang = findViewById(R.id.btnBeliSekarang);

        // Ambil data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("TITLE");
            String rating = intent.getStringExtra("RATING");
            String price = intent.getStringExtra("PRICE");
            String description = intent.getStringExtra("DESCRIPTION");
            int imageResId = intent.getIntExtra("IMAGE_RES_ID", R.drawable.default_cover);

            // Set data ke komponen UI
            tvJudul.setText(title != null ? title : "Judul Tidak Tersedia");
            tvRating.setText(rating != null ? rating : "⭐ Tidak Ada Rating");
            tvPrice.setText(price != null ? price : "Harga Tidak Tersedia");
            tvDescription.setText(description != null ? description : "Deskripsi Tidak Tersedia");
            ivCover.setImageResource(imageResId);
        }

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // Fungsi tombol "Beli Sekarang"
        btnBeliSekarang.setOnClickListener(v -> {
            Intent checkoutIntent = new Intent(KomikDetail.this, KeranjangActivity.class);
            checkoutIntent.putExtra("TITLE", tvJudul.getText().toString());
            checkoutIntent.putExtra("PRICE", tvPrice.getText().toString());
            startActivity(checkoutIntent);
        });
    }
}
