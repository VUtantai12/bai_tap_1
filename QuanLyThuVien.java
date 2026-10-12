import java.util.ArrayList;
import java.util.List;

/**
 * Lop QuanLyThuVien - quan ly danh sach tai lieu (Sach, Tap chi, Bao).
 * @author Truong Thanh Trung
 */
public class QuanLyThuVien {
    public static final int LOAI_SACH = 1;
    public static final int LOAI_TAP_CHI = 2;
    public static final int LOAI_BAO = 3;

    private List<TaiLieu> danhSach = new ArrayList<>();
    public boolean tonTaiMa(String ma) {
        return timTheoMa(ma) != null;
    }
    public TaiLieu timTheoMa(String ma) {
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) {
                return tl;
            }
        }
        return null;
    }

    public boolean themTaiLieu(TaiLieu tl) {
        if (tonTaiMa(tl.getMaTaiLieu())) {
            return false;
        }
        danhSach.add(tl);
        return true;
    }
    public boolean xoaTheoMa(String ma) {
        TaiLieu tl = timTheoMa(ma);
        if (tl == null) {
            return false;
        }
        danhSach.remove(tl);
        return true;
    }
    public void hienThiThongTin() {
        if (danhSach.isEmpty()) {
            System.out.println("Thu vien chua co tai lieu nao.");
            return;
        }
        System.out.println("===== DANH SACH TAI LIEU (" + danhSach.size() + ") =====");
        for (TaiLieu tl : danhSach) {
            tl.hienThiThongTin(); 
            System.out.println("------------------------------");
        }
    }
    public void timKiemTheoLoai(int loai) {
        int dem = 0;
        for (TaiLieu tl : danhSach) {
            boolean khop = (loai == LOAI_SACH && tl instanceof Sach)
                    || (loai == LOAI_TAP_CHI && tl instanceof TapChi)
                    || (loai == LOAI_BAO && tl instanceof Bao);
            if (khop) {
                tl.hienThiThongTin();
                System.out.println("------------------------------");
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay tai lieu thuoc loai nay.");
        } else {
            System.out.println("Tim thay " + dem + " tai lieu.");
        }
    }
}
