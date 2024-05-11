package ntu.huutuong.sql_book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    //Nguồn dữ liệu cho Adapter
    ArrayList<Book> listBook;
    //Context hoạt động
    Context mContext;
    //Layout
    LayoutInflater mInfater;

    public BookAdapter(Context mContext, ArrayList<Book> listBook) {
        this.listBook = listBook;
        this.mContext = mContext;
        mInfater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookViewHolder viewItem;
        if(convertView == null){
            convertView = mInfater.inflate(R.layout.book_item, null);
            viewItem = new BookViewHolder();
            viewItem.tvID = convertView.findViewById(R.id.tvID);
            viewItem.tvName = convertView.findViewById(R.id.tvName);
            viewItem.tvPage = convertView.findViewById(R.id.tvPage);
            viewItem.tvGia = convertView.findViewById(R.id.tvPrice);
            viewItem.tvDes = convertView.findViewById(R.id.tvDes);
            convertView.setTag(viewItem);
        }
        else{
            viewItem = (BookViewHolder) convertView.getTag();
        }
        //Đặt dữ liệu lên view
        Book b = listBook.get(position);
        int bookid = b.getBookID();
        String bookName = b.getBookName();
        int bookpage = b.getPage();
        Float bookPrice = b.getPrice();
        String bookDes = b.getDescription();

        viewItem.tvID.setText("Mã sách: " + String.valueOf(bookid));
        viewItem.tvName.setText("Tên sách: " + bookName);
        viewItem.tvPage.setText("Số trang: " + String.valueOf(bookpage));
        viewItem.tvGia.setText("Đơn giá: " + String.valueOf(bookPrice) + " $");
        viewItem.tvDes.setText("Mô tả: " + bookDes);
        return convertView;
    }

    static class BookViewHolder{
        TextView tvID, tvName, tvGia, tvDes, tvPage;
    }
}