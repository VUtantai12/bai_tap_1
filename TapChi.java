/**
 * Lop TapChi - ke thua TaiLieu, them: so phat hanh, thang phat hanh.
 *
 * @author Vu Tan Tai
 */
public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,
                  int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String getLoai() {
        return "Tap chi";
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("So phat hanh   : " + soPhatHanh);
        System.out.println("Thang phat hanh: " + thangPhatHanh);
    }
}
