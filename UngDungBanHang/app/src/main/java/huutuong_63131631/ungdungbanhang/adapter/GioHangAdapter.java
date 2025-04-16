package huutuong_63131631.ungdungbanhang.adapter;

import android.content.Context;
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

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.model.GioHang;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyViewHolder> {
    Context context;
    List<GioHang> gioHangList;

    public GioHangAdapter(Context context, List<GioHang> gioHangList) {
        this.context = context;
        this.gioHangList = gioHangList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GioHang giohang = gioHangList.get(position);
        holder.item_giohang_tensanpham.setText(giohang.getTen_sp());
        holder.item_giohang_soluong.setText(giohang.getSoluong() +" ");
        Glide.with(context).load(giohang.getAnh_sp()).into(holder.item_giohang_image);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.item_giohang_gia_ban.setText(decimalFormat.format(giohang.getGia_sp()) + " Đ");
        Float gia = giohang.getSoluong() * giohang.getGia_sp();
        holder.item_giohang_tong_tien.setText(decimalFormat.format(gia) + " Đ");
    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView item_giohang_image;
        TextView item_giohang_gia_ban,
                item_giohang_tensanpham,
                item_giohang_soluong,
                item_giohang_tong_tien;

        public MyViewHolder(@NonNull View view) {
            super(view);
            item_giohang_image = view.findViewById(R.id.item_giohang_image);
            item_giohang_gia_ban = view.findViewById(R.id.item_giohang_gia_ban);
            item_giohang_tensanpham = view.findViewById(R.id.item_giohang_tensanpham);
            item_giohang_soluong = view.findViewById(R.id.item_giohang_soluong);
            item_giohang_tong_tien = view.findViewById(R.id.item_giohang_tong_tien);

        }
    }
}
