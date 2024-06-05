package com.example.tubespbo.dto.response;

public class JadwalKerjaList {
    private long id;
    private String department;
    private String tanggalKerja;
    private String namaDokter;
    private String jamMulai;
    private String jamSelesai;

    public JadwalKerjaList() {
    }

    public JadwalKerjaList(String department, String tanggalKerja, String namaDokter, String jamMulai, String jamSelesai) {
        this.department = department;
        this.tanggalKerja = tanggalKerja;
        this.namaDokter = namaDokter;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTanggalKerja() {
        return tanggalKerja;
    }

    public void setTanggalKerja(String tanggalKerja) {
        this.tanggalKerja = tanggalKerja;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }
}