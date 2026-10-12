# Quản lý thư viện - Bài tập nhóm 1 (Java)

Chương trình quản lý tài liệu của thư viện gồm **Sách, Tạp chí, Báo**, viết bằng Java theo hướng đối tượng
(kế thừa, đa hình, đóng gói).

## Thành viên và phân công

| STT | Họ tên     | Công việc | 

| 1 | Phạm Gia Huy | Lop "TaiLieu" (lớp cha), lớp "Sach" | 
| 2 | Vũ Tấn Tài (nhóm trưởng)  Lop "TapChi", lớp "Bao", "Main" (menu, nhập liệu) 
| 3 | Trương Thành Trung |  Lop "QuanLyThuVien" (thêm, xoá, hiển thị, tìm kiếm) |
## Cấu trúc lớp
```
TaiLieu (abstract)  : maTaiLieu (duy nhất), tenNhaXuatBan, soBanPhatHanh
├── Sach            : tenTacGia, soTrang
├── TapChi          : soPhatHanh, thangPhatHanh
└── Bao             : ngayPhatHanh

QuanLyThuVien       : List<TaiLieu> danhSach
                      themTaiLieu(), xoaTheoMa(), hienThiThongTin(), timKiemTheoLoai()
Main                : menu, nhập liệu, thoát chương trình


## Chức năng

1. Thêm mới tài liệu (Sách, Tạp chí, Báo), kiểm tra **mã tài liệu không được trùng**.
2. Xoá tài liệu theo mã.
3. Hiển thị thông tin tất cả tài liệu.
4. Tìm kiếm tài liệu theo loại (Sách / Tạp chí / Báo).
0. Thoát chương trình.
