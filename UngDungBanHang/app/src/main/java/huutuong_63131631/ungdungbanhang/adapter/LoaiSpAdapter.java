package huutuong_63131631.ungdungbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import huutuong_63131631.ungdungbanhang.R;
import huutuong_63131631.ungdungbanhang.model.LoaiSp;

public class LoaiSpAdapter extends BaseAdapter {
    List<LoaiSp> array;
    Context context;

    public LoaiSpAdapter(List<LoaiSp> array, Context context) {
        this.array = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView txtTenLoaiSp;
        ImageView imgHinhAnhLoaiSP;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_loaisanpham, null);
            viewHolder.txtTenLoaiSp = view.findViewById(R.id.item_tenLoaiSP);
            viewHolder.imgHinhAnhLoaiSP = view.findViewById(R.id.item_anhLoaiSp);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();

        }
        viewHolder.txtTenLoaiSp.setText(array.get(i).getTen_loaisp());
        Glide.with(context).load(array.get(i).getAnh_loaisp()).into(viewHolder.imgHinhAnhLoaiSP);
        return view;

    }
}
