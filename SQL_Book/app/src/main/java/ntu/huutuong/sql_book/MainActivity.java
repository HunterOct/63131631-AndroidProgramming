package ntu.huutuong.sql_book;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    ArrayList<Book> mylist;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvBook);
        //Bước 0. Tạo file cơ sở dữ liệu
        db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE,null);

        //Bước 1. Tạo bảng
        //Câu lệnh tạo bảng
        String sqlDeleteTableExist = "DROP TABLE IF EXISTS Books;\n";
        String sqlCreateTable = "CREATE TABLE Books(BookID integer PRIMARY KEY, BookName text, Page integer, Price Float, Description text);";

        //Thực hiện lệnh SQL
        db.execSQL(sqlDeleteTableExist);
        db.execSQL(sqlCreateTable);

        //Thêm một số dòng dữ liệu vào bảng
        String sqlInsertTable1 = "INSERT INTO Books VALUES(11, 'Python', 200, 8.88, 'Sách về Python');";
        String sqlInsertTable2 = "INSERT INTO Books VALUES(12, 'Machine Learning', 450, 29.99, 'Học máy cơ bản');";
        String sqlInsertTable3 = "INSERT INTO Books VALUES(13, 'Kinh tế học', 180, 12.50, 'Cơ bản về kinh tế');";
        String sqlInsertTable4 = "INSERT INTO Books VALUES(14, 'Lịch sử thế giới', 800, 45.75, 'Tóm tắt lịch sử');";
        String sqlInsertTable5 = "INSERT INTO Books VALUES(15, 'Văn học Việt Nam', 600, 20.67, 'Tác phẩm văn học nổi tiếng');";
        String sqlInsertTable6 = "INSERT INTO Books VALUES(16, 'Lập trình web', 750, 35.20, 'Xây dựng website từ cơ bản đến nâng cao');";
        String sqlInsertTable7 = "INSERT INTO Books VALUES(17, 'Quản trị kinh doanh', 400, 65.88, 'Cẩm nang quản lý doanh nghiệp');";
        String sqlInsertTable8 = "INSERT INTO Books VALUES(18, 'Ngôn ngữ học', 300, 22.45, 'Giới thiệu về ngôn ngữ học');";
        String sqlInsertTable9 = "INSERT INTO Books VALUES(19, 'Trí tuệ nhân tạo', 280, 55.75, 'Giới thiệu về trí tuệ nhân tạo');";
        String sqlInsertTable10 = "INSERT INTO Books VALUES(20, 'Hình học không gian', 150, 38.60, 'Bài giảng về hình học không gian');";

        db.execSQL(sqlInsertTable1);
        db.execSQL(sqlInsertTable2);
        db.execSQL(sqlInsertTable3);
        db.execSQL(sqlInsertTable4);
        db.execSQL(sqlInsertTable5);
        db.execSQL(sqlInsertTable6);
        db.execSQL(sqlInsertTable7);
        db.execSQL(sqlInsertTable8);
        db.execSQL(sqlInsertTable9);
        db.execSQL(sqlInsertTable10);
        //Để quan sát trực quan file .db => Dùng ứng dụng
        //Đóng lại để check
        db.close();

        ////////////////////----Hiển thị lên Android---/////////////////////
        //Bước 1: Mở CSDL
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE,null);

        //Bước 2: Thực thi câu lệnh Select
        String sqlSelect = "Select * FROM Books";
        Cursor cs =  db.rawQuery(sqlSelect, null);

        //Buước 3: Đổ vào biến nào đó để xử lý
        //3.1. Xây dựng model/class cho bảng Book. Ví dụ Book.java
        //3.2. Tạo biến ArrayList<Book> dsSach
        mylist = new ArrayList<Book>();
        //3.3. Duyệt lần lượt từng bảng ghi và thêm vào danhSach
        while (cs.moveToNext()){
            int idSach = cs.getInt(0);
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);

            // Tạo một đối tượng sách và thêm vào danh sách
            Book b = new Book(idSach,tenSach,soTrang,gia,mota);
            mylist.add(b);
        }

        BookAdapter adapter = new BookAdapter(this, mylist);

        lv.setAdapter(adapter);
    }
}