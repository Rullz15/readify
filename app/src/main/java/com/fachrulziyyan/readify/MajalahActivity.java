package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MajalahActivity extends AppCompatActivity {

    private RecyclerView rvMajalahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majalah);

        rvMajalahList = findViewById(R.id.rvMajalahList);
        TextView tvJmlProduk = findViewById(R.id.tvJmlProduk);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Tombol kembali
        btnBack.setOnClickListener(v -> finish());

        // LayoutManager untuk RecyclerView
        rvMajalahList.setLayoutManager(new GridLayoutManager(this, 2));
        rvMajalahList.setHasFixedSize(true);

        // Daftar majalah
        List<Majalah> majalahList = new ArrayList<>();
        majalahList.add(new Majalah("MAJALAH SANTRI 2018", "Majalah Santri edisi Maret 2018 mengangkat tema \"Persatuan untuk Kesatuan\" dengan topik persatuan dalam Islam.",
                "Rp.250.000", "4.6 (1000 Ulasan)", R.drawable.santri, "Tema besar tentang persatuan dalam Islam."));
        majalahList.add(new Majalah("MAJALAH PENDIDIKAN", "JENDELA Pendidikan dan Kebudayaan edisi Jan-Maret 2021 bertema transformasi pendidikan dan Sekolah Penggerak.",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.jendela, "Membahas transformasi pendidikan dan sekolah."));
        majalahList.add(new Majalah("MAJALAH SABILILLAH", "“Kurikulum Pemimpin Peradaban Dunia” sebagai tema yang diusung pada Majalah Pendidikan Sabilillah Edisi 43.",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.dunia, "Pemimpin peradaban dunia dan pendidikan."));
        majalahList.add(new Majalah("MAJALAH KEBAYA", "INDONESIA\nKarya Nyata Untuk Negeri.",
                "Rp.250.000", "4.8 (1000 Ulasan)", R.drawable.kebaya, "Tren Kebaya Terbaru: Edisi ini akan menampilkan tren kebaya terbaru untuk musim panas atau musim lainnya, dengan fokus pada gaya yang cocok untuk perempuan Indonesia. Pembaca akan menemukan inspirasi gaya busana kebaya, aksesori, dan tips padu padan yang stylish.\n" +
                "Inspirasi Kebaya untuk Acara Spesial: Mengingat bulan Juni dan Juli seringkali menjadi musim pernikahan dan acara formal lainnya, majalah ini akan memberikan inspirasi kebaya untuk berbagai acara spesial, seperti kebaya pengantin, kebaya wisuda, atau kebaya untuk acara resmi lainnya.\n" +
                "Tips Perawatan Kebaya di Musim Panas: Edisi ini juga dapat memberikan tips praktis tentang cara merawat kebaya selama musim panas, seperti cara mencuci kebaya dengan bahan yang ringan dan menyerap keringat, serta cara menyimpan kebaya agar tetap awet dan tidak lembap.\n" +
                "Wawancara dengan Desainer Kebaya: Majalah ini akan menampilkan wawancara eksklusif dengan desainer kebaya ternama Indonesia, yang akan berbagi tentang inspirasi, proses kreatif, dan tren kebaya terbaru mereka.\n" +
                "Profil Perempuan Berkebaya Inspiratif: Edisi ini juga dapat menampilkan profil perempuan-perempuan inspiratif yang aktif mengenakan kebaya dalam berbagai bidang, seperti pengusaha, seniman, atau aktivis."));

        // Update jumlah produk
        tvJmlProduk.setText(majalahList.size() + " Produk Ditampilkan");

        // Atur adapter
        MajalahAdapter adapter = new MajalahAdapter(this, majalahList);
        rvMajalahList.setAdapter(adapter);
    }
}
