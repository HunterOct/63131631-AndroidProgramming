package ntu_63131631.bai2_ghichu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Random;

public class NotesAdapter extends ArrayAdapter<String> {
    public NotesAdapter(Context context, ArrayList<String> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int[] colors = {R.color.ORANGE, R.color.TURQUOISE, R.color.EMERALD, R.color.PETERRIVER, R.color.color5, R.color.color5, R.color.color5, R.color.color5, R.color.color5, R.color.color5, R.color.color5, R.color.color5}; // Thay đổi này thành các màu bạn muốn sử dụng
        // Lấy dữ liệu
        String note = getItem(position);

        // kiểm tra xem view có được tái sử dụng không, nếu không thì inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview_notes, parent, false);
        }

        // lấy dữ liệu từ textview
        TextView tvNote = (TextView) convertView.findViewById(R.id.textview_notes);

        // đưa dữ liệu vào textview
        tvNote.setText(note);

        CardView cardView = (CardView) convertView.findViewById(R.id.notes_card_container);
        int colorIndex = new Random().nextInt(colors.length); // Lấy một chỉ số ngẫu nhiên từ mảng màu
        cardView.setCardBackgroundColor(getContext().getResources().getColor(colors[colorIndex])); // Đặt màu nền cho CardView

        return convertView;
    }
}