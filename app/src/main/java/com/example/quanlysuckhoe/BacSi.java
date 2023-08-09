package com.example.quanlysuckhoe;

public class BacSi {
    private int Id;
    private String MaBacSi;
    private String TenBacSi;
    private String ChuyenKhoa;
    private int SoDienThoai;
    private String KinhNghiem;
    private String TaiKhoan;
    private  String MatKhau;
    private String DiaChi;
    private String VaiTro;


    public BacSi(int id, String maBacSi, String tenBacSi, String chuyenKhoa, int soDienThoai, String kinhNghiem) {
        Id = id;
        MaBacSi = maBacSi;
        TenBacSi = tenBacSi;
        ChuyenKhoa = chuyenKhoa;
        SoDienThoai = soDienThoai;
        KinhNghiem = kinhNghiem;
    }



    public BacSi(int id, String tenBacSi, int soDienThoai, String diaChi , String chuyenKhoa, String kinhNghiem, String taiKhoan, String matKhau,String vaiTro) {
        Id = id;
        TenBacSi = tenBacSi;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi;
        ChuyenKhoa = chuyenKhoa;
        KinhNghiem = kinhNghiem;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
        VaiTro=vaiTro;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String vaiTro) {
        VaiTro = vaiTro;
    }

    public String getMaBacSi() {
        return MaBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        MaBacSi = maBacSi;
    }

    public String getTenBacSi() {
        return TenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        TenBacSi = tenBacSi;
    }

    public String getChuyenKhoa() {
        return ChuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        ChuyenKhoa = chuyenKhoa;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getKinhNghiem() {
        return KinhNghiem;
    }

    public void setKinhNghiem(String kinhNghiem) {
        KinhNghiem = kinhNghiem;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
