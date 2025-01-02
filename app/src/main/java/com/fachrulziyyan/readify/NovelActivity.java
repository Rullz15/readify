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

public class NovelActivity extends AppCompatActivity {

    private RecyclerView rvNovelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_novel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvNovelList = findViewById(R.id.rvNovelList);

        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);


        // Set LayoutManager untuk RecyclerView
        rvNovelList.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom
        rvNovelList.setHasFixedSize(true);

        // Buat daftar novel
        List<Novel> novelList = new ArrayList<>();
        novelList.add(new Novel("Tidak Jatuh Cinta", "Rayni N.  Massardi & Erby S.\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? ",
                "Rp. 85.000", "4.6 (1000 Ulasan)", R.drawable.tjc));
        novelList.add(new Novel("Ayahku Bukan Pembohong", "TERE LIYE.\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? )",
                "Rp. 90.000", "4.8 (1000 Ulasan)", R.drawable.ayahku));
        novelList.add(new Novel("23:59", "BRIAN KHRISNA\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? ",
                "Rp. 90.000", "4.8 (1000 Ulasan)", R.drawable.n23));
        novelList.add(new Novel("BEK", "MAHFUD IKHWAN\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? ",
                "Rp. 90.000", "4.8 (1000 Ulasan)", R.drawable.bek));
        // Tambahkan item lainnya

        // Update jumlah produk ditampilkan
        tvJmlProduk.setText(novelList.size() + " Produk Ditampilkan");

        // Atur Adapter ke RecyclerView
        NovelAdapter adapter = new NovelAdapter(this, novelList);
        rvNovelList.setAdapter(adapter);
    }

}