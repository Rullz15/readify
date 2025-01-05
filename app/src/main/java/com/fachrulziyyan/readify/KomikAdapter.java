package com.fachrulziyyan.readify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KomikAdapter extends RecyclerView.Adapter<KomikAdapter.KomikViewHolder> {

    private Context context;
    private List<Komik> komikList;

    public KomikAdapter(Context context, List<Komik> komikList) {
        this.context = context;
        this.komikList = komikList;
    }

    @NonNull
    @Override
    public KomikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_komik, parent, false);
        return new KomikViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KomikViewHolder holder, int position) {
        Komik komik = komikList.get(position);

        holder.tvTitle.setText(komik.getTitle());
        holder.tvSubtitle.setText(komik.getSubtitle());
        holder.tvPrice.setText(komik.getPrice());
        holder.tvRating.setText(komik.getRating());
        holder.ivCover.setImageResource(komik.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, KomikDetail.class);
            intent.putExtra("TITLE", komik.getTitle());
            intent.putExtra("SUBTITLE", komik.getSubtitle());
            intent.putExtra("PRICE", komik.getPrice());
            intent.putExtra("RATING", komik.getRating());
            intent.putExtra("DESCRIPTION", komik.getDescription());
            intent.putExtra("IMAGE_RES_ID", komik.getImageResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return komikList.size();
    }

    public static class KomikViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvPrice, tvRating;
        ImageView ivCover;

        public KomikViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);
        }
    }
}
