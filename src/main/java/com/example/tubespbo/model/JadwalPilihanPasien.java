package com.example.tubespbo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
public class JadwalPilihanPasien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String kodePerjanjian;
    private String department;
    private String tanggalKerja;
    private String namaDokter;
    private String jamKerja;

    @Column(unique = true)
    private String emailPasien;

    @OneToOne(targetEntity = Pasien.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Pasien", referencedColumnName = "idPasien")
    Pasien pasien;

    public JadwalPilihanPasien(String department, String tanggalKerja, String namaDokter, String jamKerja, String emailPasien) {
        this.kodePerjanjian = generateKodePerjanjian();
        this.department = department;
        this.tanggalKerja = tanggalKerja;
        this.namaDokter = namaDokter;
        this.jamKerja = jamKerja;
        this.emailPasien = emailPasien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JadwalPilihanPasien() {
    }

    public String getKodePerjanjian() {
        return kodePerjanjian;
    }

    public void setKodePerjanjian(String kodePerjanjian) {
        this.kodePerjanjian = kodePerjanjian;
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

    public String getJamKerja() {
        return jamKerja;
    }

    public void setJamKerja(String jamKerja) {
        this.jamKerja = jamKerja;
    }

    public String getEmailPasien() {
        return emailPasien;
    }

    public void setEmailPasien(String emailPasien) {
        this.emailPasien = emailPasien;
    }

    private String generateKodePerjanjian() {
        // Menggunakan UUID untuk menghasilkan kode unik secara acak
        String uuid = UUID.randomUUID().toString();
        // Ambil 8 karakter pertama dari UUID
        return uuid.substring(0, 8);
    }

    public Pasien getPasien() {
        return this.pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

}
