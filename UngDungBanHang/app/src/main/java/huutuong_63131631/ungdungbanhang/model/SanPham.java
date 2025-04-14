package huutuong_63131631.ungdungbanhang.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    String ma_sp, ten_sp, anh_sp, mota;
    float gia_sp;
    String  ma_loaisp;

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getAnh_sp() {
        return anh_sp;
    }

    public void setAnh_sp(String anh_sp) {
        this.anh_sp = anh_sp;
    }

    public String get_Mota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public float getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(float gia_sp) {
        this.gia_sp = gia_sp;
    }

    public String getMa_loaisp() {
        return ma_loaisp;
    }

    public void setMa_loaisp(String ma_loaisp) {
        this.ma_loaisp = ma_loaisp;
    }
}
