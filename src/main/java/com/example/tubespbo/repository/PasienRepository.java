package com.example.tubespbo.repository;

import com.example.tubespbo.model.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasienRepository extends JpaRepository<Pasien, Long> {
    Optional<Pasien> findByEmailAndPassword(String email, String password);

    Optional<Pasien> findByEmail(String email);
}
