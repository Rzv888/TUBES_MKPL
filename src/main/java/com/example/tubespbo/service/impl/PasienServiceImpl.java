package com.example.tubespbo.service.impl;

import com.example.tubespbo.model.Pasien;
import com.example.tubespbo.repository.PasienRepository;
import com.example.tubespbo.util.BaseResponse;

import com.example.tubespbo.dto.request.LoginRequest;
import com.example.tubespbo.dto.request.SignupRequest;
import com.example.tubespbo.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasienServiceImpl implements PasienService {
    @Autowired
    private PasienRepository repository;

    @Override
    public boolean login(LoginRequest request, BaseResponse<String> baseResponse) {
        System.out.println(request.getEmail() + " " + request.getPassword());
        Optional<Pasien> usersOptional = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        System.out.println(usersOptional.isPresent());
        return usersOptional.isPresent();
    }

    @Override
    public boolean signup(SignupRequest request, BaseResponse<String> baseResponse) {
        // Cek apakah email sudah digunakan
        Optional<Pasien> existingUser = repository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Email sudah digunakan");
            return false;
        }

        // Buat objek Pasien baru
        Pasien pasien = new Pasien();
        pasien.setUsername(request.getUsername());
        pasien.setEmail(request.getEmail());
        pasien.setPassword(request.getPassword());

        // Simpan Pasien baru ke repository
        repository.save(pasien);

        // Setelah berhasil signup, set success true dan kirim pesan berhasil
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Pendaftaran berhasil");
        return true;
    }
}
