package com.example.tubespbo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String password;

    @OneToOne(targetEntity = JadwalKerja.class, cascade = CascadeType.ALL)
    JadwalKerja JadwalKerja;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "admin")
    private List<JadwalKerja> kerjaList;

    public Admin() {
    }

    public Admin(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<JadwalKerja> getKerjaList() {
        return this.kerjaList;
    }

    public void setKerjaList(JadwalKerja kerjaList) {
        this.kerjaList.add(kerjaList);
    }

    public void resetKerjaList() {
        this.kerjaList = new ArrayList<JadwalKerja>();
    }

}
