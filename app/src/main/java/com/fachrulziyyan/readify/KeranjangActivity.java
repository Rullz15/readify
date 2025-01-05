package com.fachrulziyyan.readify;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class KeranjangActivity extends AppCompatActivity implements KeranjangAdapter.OnItemActionListener {

    private RecyclerView recyclerView;
    private TextView tvTotalPrice;
    private Button btnCheckout;

    private ArrayList<Item> itemList;
    private int totalItemCount = 0;
    private int totalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        recyclerView = findViewById(R.id.recyclerView);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnCheckout = findViewById(R.id.btnCheckout);

        // Data contoh
        itemList = new ArrayList<>();
        itemList.add(new Item("Novel A", 50000, 1));
        itemList.add(new Item("Novel B", 75000, 2));

        // Setup RecyclerView
        KeranjangAdapter adapter = new KeranjangAdapter(this, itemList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        updateTotal();
    }

    @Override
    public void onItemChecked(Item item, boolean isChecked) {
        if (isChecked) {
            totalItemCount += item.getQuantity();
            totalPrice += item.getQuantity() * item.getPrice();
        } else {
            totalItemCount -= item.getQuantity();
            totalPrice -= item.getQuantity() * item.getPrice();
        }
        updateTotal();
    }

    @Override
    public void onQuantityChanged(Item item) {
        totalPrice = 0;
        totalItemCount = 0;
        for (Item i : itemList) {
            if (i.isChecked()) {
                totalPrice += i.getPrice() * i.getQuantity();
                totalItemCount += i.getQuantity();
            }
        }
        updateTotal();
    }

    private void updateTotal() {
        tvTotalPrice.setText("Total: Rp " + totalPrice);
        btnCheckout.setText("Checkout (" + totalItemCount + ")");
        btnCheckout.setEnabled(totalItemCount > 0);
    }
}
