package ntu.huutuong.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View viewItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(viewItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy Đối Tượng Hiển Thị
        LandScape landScapeHienThi = lstData.get(position);
        // TRích Thông tin
            String caption = landScapeHienThi.getLanCation();
        String tenAnh = landScapeHienThi.getLandImageName();
        // Đặt vào trưởng thông tin của holder
        holder.tvCaption.setText(caption);
        // Đặt ảnh
        String packageName = holder.itemView.getContext().getPackageName();
        // Lấy ID ảnh thông qua tên
        int imageID = holder.itemView.getResources().getIdentifier(tenAnh, "mipmap", packageName);
        holder.ivLandScape.setImageResource(imageID);
    }
    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandScape;
        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.TextViewCation);
            ivLandScape = itemView.findViewById(R.id.ImageViewland);
            itemView.setOnClickListener(this); // Đăng ký OnClickListener cho itemView

        }

        @Override
        public void onClick(View v) {
            // Xử lý sự kiện khi click vào item
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick = lstData.get(viTriDuocClick);
            //bóc tách thông tin
            String ten = phanTuDuocClick.getLanCation();
            String tenAnh = phanTuDuocClick.getLandImageName();
            //Toast tên
            String chuoiTB = "Bạn vừa click vào " + ten ;
            Toast.makeText(v.getContext(), chuoiTB, Toast.LENGTH_SHORT).show();
        }
    }
}
