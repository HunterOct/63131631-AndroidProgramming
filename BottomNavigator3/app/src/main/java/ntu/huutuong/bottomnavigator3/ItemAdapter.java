package ntu.huutuong.bottomnavigator3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    ArrayList<Item> itemList;
    public ItemAdapter( ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_land, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemTitle.setText(item.getTv_name());
        holder.itemImage.setImageResource(item.getImage_item());
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim));
    }
    @Override
    public int getItemCount() {
        if(itemList == null){
            return 0;
        }
        else
            return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemTitle;
        ImageView itemImage;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.tvName);
            itemImage = itemView.findViewById(R.id.image_item);
            cardView = itemView.findViewById(R.id.layout_cardView);
            itemView.setOnClickListener(this); // Đăng ký OnClickListener cho itemView

        }

        @Override
        public void onClick(View v) {
            // Xử lý sự kiện khi click vào item
            int viTriDuocClick = getAdapterPosition();
            Item phanTuDuocClick = itemList.get(viTriDuocClick);
            //bóc tách thông tin
            String ten = phanTuDuocClick.getTv_name();
            int tenAnh = phanTuDuocClick.getImage_item();
            //Toast tên
            String chuoiTB = "Bạn vừa click vào " + ten ;
            Toast.makeText(v.getContext(), chuoiTB, Toast.LENGTH_SHORT).show();
        }
    }
}
