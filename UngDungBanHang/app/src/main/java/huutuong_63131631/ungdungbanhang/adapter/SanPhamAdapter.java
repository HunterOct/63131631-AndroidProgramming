package huutuong_63131631.ungdungbanhang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.List;

import huutuong_63131631.ungdungbanhang.Interface.ItemClickListener;
import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.activity.ChiTietActivity;
import huutuong_63131631.ungdungbanhang.model.SanPham;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.MyViewHolder> {
    Context context;
    List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTenSp, txtGiaSp, txtMoTaSp;
        ImageView imgAnhSp;
        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtGiaSp = itemView.findViewById(R.id.item_giasp);
            txtTenSp = itemView.findViewById(R.id.item_tensp);
            imgAnhSp = itemView.findViewById(R.id.item_anhsp);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onClick(v, getAdapterPosition(), false);
            }
        }
    }

    @NonNull
    @Override
    public SanPhamAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.MyViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTenSp.setText(sanPham.getTen_sp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSp.setText("Giá: " + decimalFormat.format(sanPham.getGia_sp()) + " Đ");
        Glide.with(context).load(sanPham.getAnh_sp()).into(holder.imgAnhSp);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position, boolean isLongClick) {
                if(!isLongClick) {
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("chitiet", sanPham);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
}