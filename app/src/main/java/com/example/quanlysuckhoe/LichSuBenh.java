package com.example.quanlysuckhoe;

public class LichSuBenh {
    private int Id;
    private String TenBenh;
    private String LyDo;
    private String Time;

    public LichSuBenh(int id, String tenBenh, String lyDo, String time) {
        Id = id;
        TenBenh = tenBenh;
        LyDo = lyDo;
        Time = time;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenBenh() {
        return TenBenh;
    }

    public void setTenBenh(String tenBenh) {
        TenBenh = tenBenh;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String lyDo) {
        LyDo = lyDo;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
