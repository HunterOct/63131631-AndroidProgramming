package huutuong_63131631.ungdungbanhang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class BanhKemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<SanPham> sanPhamList;
    private static final int VIEW_TYPE_DATA = 0;
    private static final int VIEW_TYPE_LOADING = 1;


    public BanhKemAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTensp, txtGia, txtMoTa,txtID;
        ImageView imgHinhsp;
        private ItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTensp = itemView.findViewById(R.id.itembanhkem_tensp);
            txtGia = itemView.findViewById(R.id.itembanhkem_gia);
            txtMoTa = itemView.findViewById(R.id.itembanhkem_mota);
            //txtID = itemView.findViewById(R.id.itembanhkem_id);
            imgHinhsp = itemView.findViewById(R.id.itembanhkem_anhsanpham);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }



    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_DATA){
            View view = LayoutInflater.from(context).inflate(R.layout.item_banhkem, parent, false);
            return new MyViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            SanPham sanPham = sanPhamList.get(position);
            myViewHolder.txtTensp.setText(sanPham.getTen_sp().trim());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            myViewHolder.txtGia.setText("Giá: " + decimalFormat.format(sanPham.getGia_sp()) + " Đ");
            //myViewHolder.txtID.setText("ID: " + sanPham.getMa_sp());
            myViewHolder.txtMoTa.setText(sanPham.get_Mota());
            Glide.with(context).load(sanPham.getAnh_sp()).into(myViewHolder.imgHinhsp);
            myViewHolder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int pos, boolean isLongClick) {
                    if(!isLongClick) {
                        Intent intent = new Intent(context, ChiTietActivity.class);
                        intent.putExtra("chitiet", sanPham);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        } else {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return sanPhamList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_DATA;
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
