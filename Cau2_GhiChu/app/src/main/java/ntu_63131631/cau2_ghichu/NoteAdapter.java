package ntu_63131631.cau2_ghichu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<String> {
    public NoteAdapter(Context context, ArrayList<String> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Lấy dữ liệu
        String note = getItem(position);

        // kiểm tra xem view có được sử dụng không, nếu không thì sử dụng giao diện customlistview_notes
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview_notes, parent, false);
        }

        // lấy dữ liệu từ textview
        TextView tvNote = (TextView) convertView.findViewById(R.id.textview_notes);

        // đưa dữ liệu vào textview
        tvNote.setText(note);


        return convertView;
    }
}