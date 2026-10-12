import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * Lop Bao - ke thua TaiLieu, them: ngay phat hanh.
 *
 * @author Vu Tan Tai
 */
public class Bao extends TaiLieu {
    public static final DateTimeFormatter DINH_DANG_NGAY =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private LocalDate ngayPhatHanh;

    public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,
               LocalDate ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public LocalDate getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String getLoai() {
        return "Bao";
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ngay phat hanh : " + ngayPhatHanh.format(DINH_DANG_NGAY));
    }
}
