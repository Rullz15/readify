

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
    private Context context;
    private ArrayList<Item> itemList;
    private OnItemChangeListener onItemChangeListener;

    public interface OnItemChangeListener {
        void onItemCheck(Item item);
        void onItemUncheck(Item item);
        void onQuantityChange(Item item);
    }

    public KeranjangAdapter(Context context, ArrayList<Item> itemList, OnItemChangeListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.onItemChangeListener = listener;
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

        holder.tvNama.setText(item.getName());
        holder.tvHarga.setText("Rp " + item.getPrice());
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
        holder.checkBox.setChecked(item.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
            if (isChecked) {
                onItemChangeListener.onItemCheck(item);
            } else {
                onItemChangeListener.onItemUncheck(item);
            }
        });

        holder.imageMinus.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
                onItemChangeListener.onQuantityChange(item);
            }
        });

        holder.imagePlus.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
            onItemChangeListener.onQuantityChange(item);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga, tvQuantity;
        CheckBox checkBox;
        ImageView imageMinus, imagePlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvQuantity = itemView.findViewById(R.id.tvPaket1);
            checkBox = itemView.findViewById(R.id.checkbox);
            imageMinus = itemView.findViewById(R.id.imageMinus1);
            imagePlus = itemView.findViewById(R.id.imagePlus1);
        }
    }
}
