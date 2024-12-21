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

public class MajalahAdapter extends RecyclerView.Adapter<MajalahAdapter.MajalahViewHolder> {

    private Context context;
    private List<Majalah> majalahList;

    public MajalahAdapter(Context context, List<Majalah> majalahList) {
        this.context = context;
        this.majalahList = majalahList;
    }

    @NonNull
    @Override
    public MajalahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_majalah, parent, false);
        return new MajalahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MajalahViewHolder holder, int position) {
        Majalah majalah = majalahList.get(position);

        holder.tvTitle.setText(majalah.getTitle());
        holder.tvSubtitle.setText(majalah.getSubtitle());
        holder.tvPrice.setText(majalah.getPrice());
        holder.tvRating.setText(majalah.getRating());
        holder.ivCover.setImageResource(majalah.getImageResId());

        // Menambahkan klik pada item
//        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(context, NovelDetail1.class);
//            intent.putExtra("TITLE", majalah.getTitle());
//            intent.putExtra("SUBTITLE", majalah.getSubtitle());
//            intent.putExtra("PRICE", majalah.getPrice());
//            intent.putExtra("RATING", majalah.getRating());
//            intent.putExtra("IMAGE_RES_ID", majalah.getImageResId());
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return majalahList.size();
    }

    public static class MajalahViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSubtitle, tvPrice, tvRating;
        ImageView ivCover;

        public MajalahViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);


        }

    }
}
