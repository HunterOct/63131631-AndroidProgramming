package ntu_63131631.bai2_ghichu;

import android.content.DialogInterface;
import android.icu.text.MessageFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String text ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ExtendedFloatingActionButton btnNote = findViewById(R.id.btn_add_note);
        TextView tvNote = findViewById(R.id.tv);
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
                TextInputEditText editText = view1.findViewById(R.id.edit_text_notes);
                AlertDialog alertDialog = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Ghi Chú Mới")
                        .setView(view1)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvNote.setText(MessageFormat.format("Ghi chú: {0}" , Objects.requireNonNull(editText.getText())));
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