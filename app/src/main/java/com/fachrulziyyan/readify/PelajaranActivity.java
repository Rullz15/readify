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

public class PelajaranActivity extends AppCompatActivity {

    private RecyclerView rvPelajaranList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pelajaran);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvPelajaranList = findViewById(R.id.rvPelajaranList);
        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);

        // Set LayoutManager untuk RecyclerView
        rvPelajaranList.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom
        rvPelajaranList.setHasFixedSize(true);

        // Buat daftar novel
        List<Pelajaran> pelajaranList = new ArrayList<>();
        pelajaranList.add(new Pelajaran("EVALUASI PENDIDIKAN", "YESSY NUR ENDAH SARY\n" +
                "Buku pelajaran kewarga negaraan",
                "Rp. 185.000", "4.6(1000 Ulasan)", R.drawable.evaluasi));
        pelajaranList.add(new Pelajaran("PPKN", "SRI UTAMININGSIH.\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? )",
                "Rp. 180.000", "4.8 (1000 Ulasan)", R.drawable.garuda));
        pelajaranList.add(new Pelajaran("CODING BOOK", "TECHNOLOGY\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? ",
                "Rp. 180.000", "4.8 (1000 Ulasan)", R.drawable.coding));
        pelajaranList.add(new Pelajaran("PENGANTAR BISNIS", "SATTAR\n" +
                "Seberapa jauhkah gambar menggambarkan tulisan,\n" +
                "atau tulisan mungkin saja menyastrakan gambar? ",
                "Rp. 180.000", "4.8 (1000 Ulasan)", R.drawable.bisnis));
        // Tambahkan item lainnya

        // Update jumlah produk ditampilkan
        tvJmlProduk.setText(pelajaranList.size() + " Produk Ditampilkan");

        // Atur Adapter ke RecyclerView
        PelajaranAdapter adapter = new PelajaranAdapter(this, pelajaranList);
        rvPelajaranList.setAdapter(adapter);
    }
}