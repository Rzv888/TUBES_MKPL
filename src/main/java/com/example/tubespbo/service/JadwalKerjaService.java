package com.example.tubespbo.service;

import com.example.tubespbo.dto.request.JadwalKerjaRequest;
import com.example.tubespbo.dto.response.JadwalKerjaList;

import java.util.List;

public interface JadwalKerjaService {
    List<JadwalKerjaList> getAllJadwalKerja();
    void createJadwalKerja(JadwalKerjaRequest request);
    // Other CRUD operations (e.g., updateJadwalKerja, deleteJadwalKerja) can be added here
}
