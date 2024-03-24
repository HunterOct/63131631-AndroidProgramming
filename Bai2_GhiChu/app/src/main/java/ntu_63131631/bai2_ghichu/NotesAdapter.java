package ntu_63131631.bai2_ghichu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<String> {
    public NotesAdapter(Context context, ArrayList<String> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Lấy dữ liệu
        String note = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview_notes, parent, false);
        }

        // Lookup view for data population
        TextView tvNote = (TextView) convertView.findViewById(R.id.textview_notes);

        // Populate the data into the template view using the data object
        tvNote.setText(note);

        // Return the completed view to render on screen
        return convertView;
    }
}