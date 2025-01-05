package com.fachrulziyyan.readify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.ViewHolder> {

    public interface OnItemActionListener {
        void onItemChecked(Item item, boolean isChecked);
        void onQuantityChanged(Item item);
    }

    private Context context;
    private ArrayList<Item> itemList;
    private OnItemActionListener listener;

    public KeranjangAdapter(Context context, ArrayList<Item> itemList, OnItemActionListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_keranjang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.tvName.setText(item.getName());
        holder.tvPrice.setText("Rp " + item.getPrice());
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
        holder.checkBox.setChecked(item.isChecked());

        // Listener untuk checkbox
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
            listener.onItemChecked(item, isChecked);
        });

        // Listener untuk tombol minus
        holder.btnMinus.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
                listener.onQuantityChanged(item);
            }
        });

        // Listener untuk tombol plus
        holder.btnPlus.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
            listener.onQuantityChanged(item);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvQuantity;
        CheckBox checkBox;
        ImageView btnMinus, btnPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNama);
            tvPrice = itemView.findViewById(R.id.tvHarga);
            tvQuantity = itemView.findViewById(R.id.tvPaket1);
            checkBox = itemView.findViewById(R.id.checkbox);
            btnMinus = itemView.findViewById(R.id.imageMinus1);
            btnPlus = itemView.findViewById(R.id.imagePlus1);
        }
    }
}
