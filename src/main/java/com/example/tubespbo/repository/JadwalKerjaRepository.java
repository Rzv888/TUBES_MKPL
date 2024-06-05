package com.example.tubespbo.repository;

import com.example.tubespbo.model.JadwalKerja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalKerjaRepository extends JpaRepository<JadwalKerja, Integer> {
    
}
