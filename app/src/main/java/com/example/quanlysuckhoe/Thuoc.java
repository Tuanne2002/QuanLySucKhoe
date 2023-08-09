package com.example.quanlysuckhoe;

public class Thuoc {
    private int Id;
    private String MaBenhNhan;
    private String TenBenhNhan;
    private String TenThuoc;
    private String SoLuong;
    private String CongDung;
    private String NgayBD;
    private String NgayKT;

    public Thuoc(int id,String tenBenhNhan ,String tenThuoc, String soLuong, String congDung, String ngayBD, String ngayKT) {
        Id = id;
        TenBenhNhan=tenBenhNhan;
        TenThuoc = tenThuoc;
        SoLuong = soLuong;
        CongDung = congDung;
        NgayBD = ngayBD;
        NgayKT = ngayKT;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenThuoc() {
        return TenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        TenThuoc = tenThuoc;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getCongDung() {
        return CongDung;
    }

    public void setCongDung(String congDung) {
        CongDung = congDung;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String ngayBD) {
        NgayBD = ngayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String ngayKT) {
        NgayKT = ngayKT;
    }
}
