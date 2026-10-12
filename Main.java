import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Lop Main - menu chuong trinh va nhap lieu tu ban phim.
 *
 * @author Vu Tan Tai
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyThuVien ql = new QuanLyThuVien();
        nhapDuLieuMau(ql);

        int chon;
        do {
            hienThiMenu();
            chon = nhapSoNguyen("Chon chuc nang: ", 0, 4);
            switch (chon) {
                case 1:
                    themTaiLieu(ql);
                    break;
                case 2:
                    xoaTaiLieu(ql);
                    break;
                case 3:
                    ql.hienThiThongTin();
                    break;
                case 4:
                    timKiem(ql);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh. Tam biet!");
                    break;
            }
        } while (chon != 0);
    }

    private static void hienThiMenu() {
        System.out.println();
        System.out.println("========== QUAN LY THU VIEN ==========");
        System.out.println("1. Them moi tai lieu (Sach, Tap chi, Bao)");
        System.out.println("2. Xoa tai lieu theo ma");
        System.out.println("3. Hien thi thong tin tai lieu");
        System.out.println("4. Tim kiem tai lieu theo loai");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("======================================");
    }

    private static void themTaiLieu(QuanLyThuVien ql) {
        System.out.println("Chon loai: 1. Sach | 2. Tap chi | 3. Bao");
        int loai = nhapSoNguyen("Loai tai lieu: ", 1, 3);

       
        String ma = nhapChuoi("Ma tai lieu: ");
        if (ql.tonTaiMa(ma)) {
            System.out.println("Ma tai lieu \"" + ma + "\" da ton tai. Them that bai!");
            return;
        }
        String nxb = nhapChuoi("Ten nha xuat ban: ");
        int soBan = nhapSoNguyen("So ban phat hanh: ", 1, Integer.MAX_VALUE);

        TaiLieu tl;
        switch (loai) {
            case QuanLyThuVien.LOAI_SACH:
                String tacGia = nhapChuoi("Ten tac gia: ");
                int soTrang = nhapSoNguyen("So trang: ", 1, Integer.MAX_VALUE);
                tl = new Sach(ma, nxb, soBan, tacGia, soTrang);
                break;
            case QuanLyThuVien.LOAI_TAP_CHI:
                int soPH = nhapSoNguyen("So phat hanh: ", 1, Integer.MAX_VALUE);
                int thang = nhapSoNguyen("Thang phat hanh (1-12): ", 1, 12);
                tl = new TapChi(ma, nxb, soBan, soPH, thang);
                break;
            default:
                LocalDate ngay = nhapNgay("Ngay phat hanh (dd/MM/yyyy): ");
                tl = new Bao(ma, nxb, soBan, ngay);
                break;
        }

        if (ql.themTaiLieu(tl)) {
            System.out.println("Them " + tl.getLoai().toLowerCase() + " thanh cong!");
        } else {
            System.out.println("Them that bai!");
        }
    }

    private static void xoaTaiLieu(QuanLyThuVien ql) {
        String ma = nhapChuoi("Nhap ma tai lieu can xoa: ");
        if (ql.xoaTheoMa(ma)) {
            System.out.println("Da xoa tai lieu co ma " + ma);
        } else {
            System.out.println("Khong tim thay tai lieu co ma " + ma);
        }
    }

    private static void timKiem(QuanLyThuVien ql) {
        System.out.println("Tim theo loai: 1. Sach | 2. Tap chi | 3. Bao");
        int loai = nhapSoNguyen("Loai can tim: ", 1, 3);
        ql.timKiemTheoLoai(loai);
    }

  

    private static String nhapChuoi(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Khong duoc de trong, nhap lai!");
        }
    }

    private static int nhapSoNguyen(String thongBao, int min, int max) {
        while (true) {
            System.out.print(thongBao);
            try {
                int so = Integer.parseInt(sc.nextLine().trim());
                if (so >= min && so <= max) {
                    return so;
                }
                System.out.println("Gia tri phai tu " + min + " den "
                        + (max == Integer.MAX_VALUE ? "lon hon" : String.valueOf(max)) + ", nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen!");
            }
        }
    }

    private static LocalDate nhapNgay(String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                return LocalDate.parse(sc.nextLine().trim(), Bao.DINH_DANG_NGAY);
            } catch (DateTimeParseException e) {
                System.out.println("Ngay khong hop le, vi du dung: 15/03/2026");
            }
        }
    }

   
    private static void nhapDuLieuMau(QuanLyThuVien ql) {
        ql.themTaiLieu(new Sach("S01", "NXB Kim Dong", 5000, "Nguyen Nhat Anh", 250));
        ql.themTaiLieu(new TapChi("TC01", "NXB Tre", 3000, 12, 10));
        ql.themTaiLieu(new Bao("B01", "NXB Tuoi Tre", 10000, LocalDate.of(2026, 10, 12)));
    }
}
