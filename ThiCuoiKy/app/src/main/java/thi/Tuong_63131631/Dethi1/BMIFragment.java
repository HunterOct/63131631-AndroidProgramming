package thi.Tuong_63131631.Dethi1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;


public class BMIFragment extends Fragment {
    TextInputEditText editTextChieuCao, editTextCanNang;
    TextView txtKetQua;
    Button TinhBMI;
    int chieuCao, canNang;
    String ketQua;
    public BMIFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_b_m_i, container, false);

        editTextChieuCao = rootView.findViewById(R.id.edt_height);
        editTextCanNang = rootView.findViewById(R.id.edt_weight);
        TinhBMI = rootView.findViewById(R.id.btnTinhBMI);
        txtKetQua = rootView.findViewById(R.id.txKetQua);
        TinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhBMI(v);
            }
        });
        return rootView;
    }
    public void TinhBMI(View v){

        String strChieuCao = editTextChieuCao.getText().toString();
        String strCanNang = editTextCanNang.getText().toString();

        // Kiểm tra xem người dùng đã nhập chiều cao và cân nặng chưa
        if (strChieuCao.isEmpty() || strCanNang.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập cả chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
            return;
        }
        chieuCao = Integer.parseInt(strChieuCao);
        canNang = Integer.parseInt(strCanNang);
        double chieuCaoM = chieuCao / 100.0;
        double bmi = canNang / (chieuCaoM * chieuCaoM);
        if (bmi < 18.5){
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String redText = "gầy";
            String remainingText = "\nHãy bổ sung thêm chất dinh dưỡng bạn nhé.";
            SpannableString spannableString = new SpannableString(ketQua + redText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.RED), ketQua.length(), (ketQua + redText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        } else if (bmi < 24.9){
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String greenText = "bình thường";
            String remainingText = "\nTiếp tục ăn uống điều độ nhé !!!";
            SpannableString spannableString = new SpannableString(ketQua + greenText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2ecc71")), ketQua.length(), (ketQua + greenText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        } else if (bmi < 29.9){
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String orangeText = "thừa cân";
            String remainingText = "\nHãy tập thể dục thường xuyên nhé.";
            SpannableString spannableString = new SpannableString(ketQua + orangeText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA500")), ketQua.length(), (ketQua + orangeText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        } else if (bmi < 34.9){
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String redText = "béo phì độ I";
            String remainingText = "\nHãy tập thể dục thường xuyên nhé.";
            SpannableString spannableString = new SpannableString(ketQua + redText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.RED), ketQua.length(), (ketQua + redText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        } else if (bmi < 39.9){
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String redText = "béo phì độ II";
            String remainingText = "\nHãy tập thể dục thường xuyên nhé.";
            SpannableString spannableString = new SpannableString(ketQua + redText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.RED), ketQua.length(), (ketQua + redText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        } else {
            String ketQua = String.format("Chỉ Số BMI của bạn là: %.2f\nBạn thuộc tuýp người ", bmi);
            String redText = "béo phì độ III";
            String remainingText = "\nCó vẻ bạn nên đi gặp bác sĩ.";
            SpannableString spannableString = new SpannableString(ketQua + redText + remainingText);
            spannableString.setSpan(new ForegroundColorSpan(Color.RED), ketQua.length(), (ketQua + redText).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtKetQua.setText(spannableString);
        }
    }
}