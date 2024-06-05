package com.example.tubespbo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pasien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPasien;
    private String email;
    private String username;
    private String password;

    @OneToOne(targetEntity = JadwalPilihanPasien.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_jadwal", referencedColumnName = "id")
    JadwalPilihanPasien jadwalPilihanPasien;

    public Pasien() {
    }

    public Pasien(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JadwalPilihanPasien getJadwalPilihanPasien() {
        return this.jadwalPilihanPasien;
    }

    public void setJadwalPilihanPasien(JadwalPilihanPasien jadwalPilihanPasien) {
        this.jadwalPilihanPasien = jadwalPilihanPasien;
    }

}
