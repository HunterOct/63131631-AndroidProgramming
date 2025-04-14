package huutuong_63131631.ungdungbanhang.retrofit;

import huutuong_63131631.ungdungbanhang.model.LoaiSpModel;
import huutuong_63131631.ungdungbanhang.model.SanPhamModel;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getsanpham.php")
    Observable<SanPhamModel> getSanPham();

    @POST("chitietsanpham.php")
    @FormUrlEncoded
    Observable<SanPhamModel> getChiTietSanPham(
            @Field("page") int page,
            @Field("ma_loaisp") String ma_loaisp
    );
}