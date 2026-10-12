/**
 * Lop TaiLieu - lop cha (truu tuong) cua Sach, TapChi, Bao.
 * @author Pham Gia Huy
 */
public abstract class TaiLieu {
    private String maTaiLieu;
    private String tenNhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public abstract String getLoai();

    public void hienThiThongTin() {
        System.out.println("Loai           : " + getLoai());
        System.out.println("Ma tai lieu    : " + maTaiLieu);
        System.out.println("Nha xuat ban   : " + tenNhaXuatBan);
        System.out.println("So ban phat hanh: " + soBanPhatHanh);
    }
}
