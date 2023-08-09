package com.example.quanlysuckhoe;

public class BenhNhan {
    private int Id;
    private String MaBenhNhan;
    private String TenBenhNhan;
    private String GioiTinh;
    private String DiaChi;
    private int Phone;
    private String NgaySinh;
    private String BenhAn;
    private String TaiKhoan;
    private String MatKhau;

    public BenhNhan(int id, String maBenhNhan, String tenBenhNhan, String gioiTinh, String diaChi, int phone, String benhAn) {
        Id = id;
        MaBenhNhan = maBenhNhan;
        TenBenhNhan = tenBenhNhan;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
        Phone = phone;
        BenhAn = benhAn;
    }

    public BenhNhan(int id, String tenBenhNhan, String gioiTinh, String diaChi, int phone, String ngaySinh, String taiKhoan, String matKhau) {
        Id = id;
        TenBenhNhan = tenBenhNhan;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
        Phone = phone;
        NgaySinh = ngaySinh;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
    }

    public BenhNhan(int id, String maBenhNhan, String tenBenhNhan, String gioiTinh, String diaChi, int phone, String ngaySinh, String benhAn, String taiKhoan, String matKhau) {
        Id = id;
        MaBenhNhan = maBenhNhan;
        TenBenhNhan = tenBenhNhan;
        GioiTinh = gioiTinh;
        DiaChi = diaChi;
        Phone = phone;
        NgaySinh = ngaySinh;
        BenhAn = benhAn;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getMaBenhNhan() {
        return MaBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        MaBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return TenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        TenBenhNhan = tenBenhNhan;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getBenhAn() {
        return BenhAn;
    }

    public void setBenhAn(String benhAn) {
        BenhAn = benhAn;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }
}
