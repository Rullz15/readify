package com.fachrulziyyan.readify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KomikActivity extends AppCompatActivity {

    private RecyclerView rvKomikList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_komik);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvKomikList = findViewById(R.id.rvkomikList);
        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);

        // Set LayoutManager untuk RecyclerView
        rvKomikList.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom
        rvKomikList.setHasFixedSize(true);

        // Buat daftar Komik
        List<Komik> komikList = new ArrayList<>();
        komikList.add(new Komik("KOMIK ONE PIECE", "One Piece volume 102 menampilkan " +
                "Luffy dan karakter utama lainnya dalam pose aksi epik dengan latar penuh warna.",
                "Rp.150.000", "4.6 (1000 Ulasan)", R.drawable.piece));
        komikList.add(new Komik("NARUTO : THE ANIMATION", "Naruto: The Animation " +
                "Chronicle menampilkan Naruto, Sasuke, dan Sakura dengan latar merah yang ikonik.",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.naruto));
        komikList.add(new Komik("ACE OF THE DIAMOND", "Serial ini mengikuti Eijun " +
                "Sawamura, seorang pelempar bisbol dengan gaya melempar yang tidak biasa.",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.diamond));
        komikList.add(new Komik("KAIJU", "Cerita Kaiju No. 8 berlatarkan tempat negara" +
                " Jepang dan menceritakan tentang serangan monster mematikan",
                "Rp.150.000", "4.8 (1000 Ulasan)", R.drawable.kaiju));
        // Tambahkan item lainnya

        // Update jumlah produk ditampilkan
        tvJmlProduk.setText(komikList.size() + " Produk Ditampilkan");

        // Atur Adapter ke RecyclerView
        KomikAdapter adapter = new KomikAdapter(this, komikList);
        rvKomikList.setAdapter(adapter);
    }
}