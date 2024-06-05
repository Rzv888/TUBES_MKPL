package com.example.tubespbo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tubespbo.model.JadwalPilihanPasien;

public interface JadwalPilihanPasienRepository extends JpaRepository<JadwalPilihanPasien, Integer> {

    JadwalPilihanPasien findByEmailPasien(String email);

    List<JadwalPilihanPasien> findById(int id);

}
