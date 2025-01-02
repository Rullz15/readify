package com.fachrulziyyan.readify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PelajaranAdapter extends RecyclerView.Adapter<PelajaranAdapter.PelajaranViewHolder> {
    private Context context;
    private List<Pelajaran> pelajaranList;

    public PelajaranAdapter(Context context, List<Pelajaran> pelajaranList) {
        this.context = context;
        this.pelajaranList = pelajaranList;
    }

    @NonNull
    @Override
    public PelajaranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pelajaran, parent, false);
        return new PelajaranAdapter.PelajaranViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PelajaranViewHolder holder, int position) {
        Pelajaran pelajaran = pelajaranList.get(position);

        holder.tvTitle.setText(pelajaran.getTitle());
        holder.tvSubtitle.setText(pelajaran.getSubtitle());
        holder.tvPrice.setText(pelajaran.getPrice());
        holder.tvRating.setText(pelajaran.getRating());
        holder.ivCover.setImageResource(pelajaran.getImageResId());
    }

    public int getItemCount() {
        return pelajaranList.size();
    }

    public static class PelajaranViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvPrice, tvRating;
        ImageView ivCover;

        public PelajaranViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);


        }

    }
}
