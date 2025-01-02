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

public class MajalahActivity extends AppCompatActivity {

    private RecyclerView rvMajalahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_majalah);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvMajalahList = findViewById(R.id.rvMajalahList);

        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);


        // Set LayoutManager untuk RecyclerView
        rvMajalahList.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom
        rvMajalahList.setHasFixedSize(true);

        // Buat daftar novel
        List<Majalah> majalahList = new ArrayList<>();
        majalahList.add(new Majalah("MAJALAH SANTRI 2018", "Majalah Santri edisi " +
                "Maret 2018 mengangkat tema \"Persatuan untuk Kesatuan\" dengan topik persatuan dalam Islam.",
                "Rp.250.000", "4.6 (1000 Ulasan)", R.drawable.santri));
        majalahList.add(new Majalah("MAJALAH PENDIDIKAN", "JENDELA Pendidikan dan " +
                "Kebudayaan edisi Jan-Maret 2021 bertema transformasi pendidikan dan Sekolah Penggerak. ",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.jendela));
        majalahList.add(new Majalah("MAJALAH SABILILLAH", "“Kurikulum Pemimpin Peradaban " +
                "Dunia” sebagai tema yang diusung pada Majalah Pendidikan Sabilillah Edisi 43.",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.dunia));
        majalahList.add(new Majalah("BEK", "TEMPO\n" +
                "Kaesang Pangarep menhadi kepla daerah menyusul dua kakanya ",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.tempo));
        // Tambahkan item lainnya

        // Update jumlah produk ditampilkan
        tvJmlProduk.setText(majalahList.size() + " Produk Ditampilkan");

        // Atur Adapter ke RecyclerView
        MajalahAdapter adapter = new MajalahAdapter(this, majalahList);
        rvMajalahList.setAdapter(adapter);
    }
}