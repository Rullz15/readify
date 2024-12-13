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

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelViewHolder> {

    private Context context;
    private List<Novel> novelList;

    public NovelAdapter(Context context, List<Novel> novelList) {
        this.context = context;
        this.novelList = novelList;
    }

    @NonNull
    @Override
    public NovelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_novel, parent, false);
        return new NovelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelViewHolder holder, int position) {
        Novel novel = novelList.get(position);

        holder.tvTitle.setText(novel.getTitle());
        holder.tvSubtitle.setText(novel.getSubtitle());
        holder.tvPrice.setText(novel.getPrice());
        holder.tvRating.setText(novel.getRating());
        holder.ivCover.setImageResource(novel.getImageResId());

        // Menambahkan klik pada item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NovelDetail1.class);
            intent.putExtra("TITLE", novel.getTitle());
            intent.putExtra("SUBTITLE", novel.getSubtitle());
            intent.putExtra("PRICE", novel.getPrice());
            intent.putExtra("RATING", novel.getRating());
            intent.putExtra("IMAGE_RES_ID", novel.getImageResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return novelList.size();
    }

    public static class NovelViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvPrice, tvRating;
        ImageView ivCover;

        public NovelViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);


        }

    }
}
