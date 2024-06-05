package com.example.tubespbo.service.impl;

import com.example.tubespbo.dto.request.JadwalKerjaRequest;
import com.example.tubespbo.dto.response.JadwalKerjaList;
import com.example.tubespbo.model.JadwalKerja;
import com.example.tubespbo.repository.JadwalKerjaRepository;
import com.example.tubespbo.service.JadwalKerjaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JadwalKerjaServiceImpl implements JadwalKerjaService {

    private final JadwalKerjaRepository jadwalKerjaRepository;

    @Autowired
    public JadwalKerjaServiceImpl(JadwalKerjaRepository jadwalKerjaRepository) {
        this.jadwalKerjaRepository = jadwalKerjaRepository;
    }

    @Override
    public List<JadwalKerjaList> getAllJadwalKerja() {
        List<JadwalKerja> jadwalKerjaList = jadwalKerjaRepository.findAll();
        return jadwalKerjaList.stream()
                .map(this::convertToJadwalKerjaListDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createJadwalKerja(JadwalKerjaRequest request) {
        JadwalKerja jadwalKerja = new JadwalKerja();
        BeanUtils.copyProperties(request, jadwalKerja);
        jadwalKerjaRepository.save(jadwalKerja);
    }

    // Other CRUD operations (e.g., updateJadwalKerja, deleteJadwalKerja) can be added here

    private JadwalKerjaList convertToJadwalKerjaListDto(JadwalKerja jadwalKerja) {
        JadwalKerjaList jadwalKerjaList = new JadwalKerjaList();
        BeanUtils.copyProperties(jadwalKerja, jadwalKerjaList);
        return jadwalKerjaList;
    }
}
