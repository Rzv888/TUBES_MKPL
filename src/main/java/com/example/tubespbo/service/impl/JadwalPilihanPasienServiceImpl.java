package com.example.tubespbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tubespbo.model.JadwalPilihanPasien;
import com.example.tubespbo.repository.JadwalPilihanPasienRepository;
import com.example.tubespbo.service.JadwalPilihanPasienService;

@Service
public class JadwalPilihanPasienServiceImpl implements JadwalPilihanPasienService {
    private final JadwalPilihanPasienRepository jadwalPilihanPasienRepository;

    @Autowired
    public JadwalPilihanPasienServiceImpl(JadwalPilihanPasienRepository jadwalPilihanPasienRepository) {
        this.jadwalPilihanPasienRepository = jadwalPilihanPasienRepository;
    }

    @Override
    public JadwalPilihanPasien saveJadwalPilihanPasien(JadwalPilihanPasien jadwalPilihanPasien) {
        return jadwalPilihanPasienRepository.save(jadwalPilihanPasien);
    }
}
