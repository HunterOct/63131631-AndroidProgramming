package thi.Tuong_63131631.Dethi1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    //Nguồn dữ liệu cho Adapter
    ArrayList<Notes> listNotes;
    //Context hoạt động
    Context mContext;
    //Layout
    LayoutInflater mInfater;

    public NotesAdapter(Context mContext, ArrayList<Notes> listBook) {
        this.listNotes = listBook;
        this.mContext = mContext;
        mInfater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return listNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookViewHolder viewItem;
        if(convertView == null){
            convertView = mInfater.inflate(R.layout.note_item, null);
            viewItem = new BookViewHolder();
            viewItem.tvID = convertView.findViewById(R.id.txID);
            viewItem.tvName = convertView.findViewById(R.id.txTittle);
            viewItem.tvDes = convertView.findViewById(R.id.txDes);
            convertView.setTag(viewItem);
        }
        else{
            viewItem = (BookViewHolder) convertView.getTag();
        }
        //Đặt dữ liệu lên view
        Notes b = listNotes.get(position);
        int noteid = b.getNoteId();
        String notetitle = b.getNoteName();
        String noteDes = b.getDescription();

        viewItem.tvID.setText("Mã Ghi Chú: " + String.valueOf(noteid));
        viewItem.tvName.setText("Tên Ghi Chú: " + notetitle);
        viewItem.tvDes.setText("Mô tả: " + noteDes);
        return convertView;
    }

    static class BookViewHolder{
        TextView tvID, tvName, tvDes;
    }
}