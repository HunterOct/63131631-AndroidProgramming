package ntu_63131631.bai2_ghichu;

import android.content.DialogInterface;
import android.icu.text.MessageFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ListView lv_Notes;
    ExtendedFloatingActionButton btnNote;
    // Luu trữ Danh Sách note
    ArrayList<String> dsNote;
    NotesAdapter nguonDuLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Ẩn thanh tiêu đề
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        // Lấy ID
        btnNote = findViewById(R.id.btn_add_note);
        lv_Notes = (ListView) findViewById(R.id.list_view_notes);
        dsNote = new ArrayList<String>();
        //custom adapter
        nguonDuLieu = new NotesAdapter(this,dsNote);
        lv_Notes.setAdapter(nguonDuLieu);

        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
                // lấy dữ liệu từ dialog
                TextInputEditText editTextTitle = view1.findViewById(R.id.edit_text_title);
                TextInputEditText editTextNotes = view1.findViewById(R.id.edit_text_notes);
                AlertDialog alertDialog = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Ghi Chú Mới")
                        .setView(view1)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Nhập và lưu ghi chú
                                String title = Objects.requireNonNull(editTextTitle.getText()).toString();
                                String notes = Objects.requireNonNull(editTextNotes.getText()).toString();
                                dsNote.add(title + "\n" + notes);
                                if (!dsNote.isEmpty()) {
                                    findViewById(R.id.cs_background).setVisibility(View.GONE);
                                }
                                nguonDuLieu.notifyDataSetChanged(); // Thông báo cho adapter rằng dữ liệu đã thay đổi
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("Huỷ Bỏ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create();
                alertDialog.show();
            }
        });
    }
}
