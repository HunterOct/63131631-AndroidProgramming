package ntu.huutuong.bottomnavigator3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class CaculatorFragment extends Fragment {
    TextView StrKQ ,StrPhepTinh;
    Button Cong ,Tru,Nhan ,Chia;
    TextInputEditText editTextA;
    TextInputEditText editTextB;

    public CaculatorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_caculator, container, false);
        StrKQ = rootView.findViewById(R.id.txKetQua);
        StrPhepTinh = rootView.findViewById(R.id.txPhepTinh);
        editTextA = rootView.findViewById(R.id.edt_text_A);
        editTextB = rootView.findViewById(R.id.edt_text_B);
        Cong = rootView.findViewById(R.id.btnCong);
        Tru = rootView.findViewById(R.id.btnTru);
        Nhan = rootView.findViewById(R.id.btnNhan);
        Chia = rootView.findViewById(R.id.btnChia);

        StrPhepTinh.setText("+");
        Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrPhepTinh.setText("+");
                PhepTinhCong(v);
            }
        });
        Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrPhepTinh.setText("-");
                PhepTinhTru(v);
            }
        });
        Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrPhepTinh.setText("x");
                PhepTinhNhan(v);
            }
        });
        Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrPhepTinh.setText("/");
                PhepTinhChia(v);
            }
        });
        return rootView;
    }
    public void PhepTinhCong(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = editTextA.getText().toString();
        String SoB = editTextB.getText().toString();
        if (SoA.isEmpty() || SoB.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return;
        }
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A + So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhTru(View view){
        // Lay du lieu tu o nhap

        // đổi dững  liệu sang kiểu string
         String SoA = editTextA.getText().toString();
         String SoB = editTextB.getText().toString();
        if (SoA.isEmpty() || SoB.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return;
        }
        // CHuyển dữ liệu sang số
         int So_A = Integer.parseInt(SoA);
         int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A - So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhNhan(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = editTextA.getText().toString();
        String SoB = editTextB.getText().toString();
        if (SoA.isEmpty() || SoB.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return;
        }
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A * So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
    public void PhepTinhChia(View view){
        // Lay du lieu tu o nhap

        // đổi dữ liệu sang kiểu string
        String SoA = editTextA.getText().toString();
        String SoB = editTextB.getText().toString();
        if (SoA.isEmpty() || SoB.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập số", Toast.LENGTH_SHORT).show();
            return;
        }
        // CHuyển dữ liệu sang số
        int So_A = Integer.parseInt(SoA);
        int So_B = Integer.parseInt(SoB);
        // Tinh Toan
        int Cong = So_A / So_B;
        // Chuyển DỮ liệu lại thành String
        String KQ = String.valueOf(Cong);
        StrKQ.setText(KQ);

    }
}