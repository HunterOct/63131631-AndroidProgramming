package ntu.huutuong.examlist;

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
        View viewItem = cai_bom.inflate(R.layout.exam_card, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(viewItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy Đối Tượng Hiển Thị
        LandScape landScapeHienThi = lstData.get(position);
        // TRích Thông tin
        String caption = landScapeHienThi.getLanCation();
        String date = landScapeHienThi.getLanCation();
        String message = landScapeHienThi.getLanCation();

        // Đặt vào trưởng thông tin của holder
        holder.tvCaption.setText(caption);
        holder.tvDate.setText(date);
        holder.tvMessage.setText(message);


    }
    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        TextView tvDate;
        TextView tvMessage;
        ImageView ivLandScape;
        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.examName);
            tvDate = itemView.findViewById(R.id.examDate);
            tvMessage = itemView.findViewById(R.id.examMessage);
            itemView.setOnClickListener(this); // Đăng ký OnClickListener cho itemView

        }

        @Override
        public void onClick(View v) {
            // Xử lý sự kiện khi click vào item
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick = lstData.get(viTriDuocClick);
            //bóc tách thông tin
            String ten = phanTuDuocClick.getLanCation();

            //Toast tên
            String chuoiTB = "Bạn vừa click vào " + ten ;
            Toast.makeText(v.getContext(), chuoiTB, Toast.LENGTH_SHORT).show();
        }
    }
}
