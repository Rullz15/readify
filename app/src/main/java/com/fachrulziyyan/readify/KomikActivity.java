package com.fachrulziyyan.readify;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KomikActivity extends AppCompatActivity {

    private RecyclerView rvKomikList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komik);

        rvKomikList = findViewById(R.id.rvKomikList);
        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // LayoutManager untuk RecyclerView
        rvKomikList.setLayoutManager(new GridLayoutManager(this, 2));
        rvKomikList.setHasFixedSize(true);

        // Daftar komik
        List<Komik> komikList = new ArrayList<>();
        komikList.add(new Komik("KOMIK ONE PIECE", "One Piece volume 102 menampilkan Luffy dan karakter utama lainnya dalam pose aksi epik dengan latar penuh warna.",
                "Rp.150.000", "4.6 (1000 Ulasan)", R.drawable.piece, "Luffy dan petualangan epiknya di Grand Line."));
        komikList.add(new Komik("NARUTO : THE ANIMATION", "Naruto: The Animation Chronicle menampilkan Naruto, Sasuke, dan Sakura dengan latar merah yang ikonik.",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.naruto, "Naruto dan perjuangan ninja yang penuh makna."));
        komikList.add(new Komik("ACE OF THE DIAMOND", "Serial ini mengikuti Eijun Sawamura, seorang pelempar bisbol dengan gaya melempar yang tidak biasa.",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.diamond, "Cerita penuh motivasi dan aksi bisbol."));
        komikList.add(new Komik("KAIJU", "Cerita Kaiju No. 8 berlatarkan tempat negara Jepang dan menceritakan tentang serangan monster mematikan.",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.kaiju, "Pertarungan epik melawan monster Kaiju."));

        // Update jumlah produk
        tvJmlProduk.setText(komikList.size() + " Produk Ditampilkan");

        // Atur adapter
        KomikAdapter adapter = new KomikAdapter(this, komikList);
        rvKomikList.setAdapter(adapter);
    }
}
