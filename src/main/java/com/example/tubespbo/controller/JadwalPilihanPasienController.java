package com.example.tubespbo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tubespbo.model.Admin;
import com.example.tubespbo.model.JadwalKerja;
import com.example.tubespbo.model.JadwalPilihanPasien;
import com.example.tubespbo.model.Pasien;
import com.example.tubespbo.repository.JadwalKerjaRepository;
import com.example.tubespbo.repository.JadwalPilihanPasienRepository;
import com.example.tubespbo.repository.PasienRepository;
import com.example.tubespbo.service.JadwalPilihanPasienService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JadwalPilihanPasienController {

    private final JadwalPilihanPasienService jadwalPilihanPasienService;

    @Autowired
    private JadwalPilihanPasienRepository jadwalPilihanPasienRepository;

    @Autowired
    private JadwalKerjaRepository jadwalKerjaRepo;

    @Autowired
    private PasienRepository pasienRepo;

    @Autowired
    public JadwalPilihanPasienController(JadwalPilihanPasienService jadwalPilihanPasienService) {
        this.jadwalPilihanPasienService = jadwalPilihanPasienService;
    }

    @PostMapping("/tambahJadwalPasien")
    public String saveJadwalPilihanPasien(@RequestParam("idJadwal") int id, HttpServletRequest session) {
        Pasien pasien = (Pasien) session.getSession().getAttribute("userLogin");
        System.out.println("masuk sini");
        if (pasien.getJadwalPilihanPasien() == null) {
            Optional<JadwalKerja> jadwalkepasienOptional = jadwalKerjaRepo.findById(id);
            if (jadwalkepasienOptional.isPresent()) {
                JadwalKerja jadwalkepasien = jadwalkepasienOptional.get();

                JadwalPilihanPasien jadwalpasien = new JadwalPilihanPasien(jadwalkepasien.getDepartment(),
                        jadwalkepasien.getTanggalKerja(), jadwalkepasien.getNamaDokter(),
                        jadwalkepasien.getJamMulai() + " - " + jadwalkepasien.getJamSelesai(), pasien.getEmail());
                pasien.setJadwalPilihanPasien(jadwalpasien);
                System.out.println("masuk sini ges");
                jadwalPilihanPasienRepository.save(jadwalpasien);
                pasienRepo.save(pasien);
                return "redirect:/preview";
            } else {
                return "redirect:/pasienDash";
            }
        } else {
            return "/pasienDash";
        }
    }

    @GetMapping("/preview")
    public String showPreview(Model model, HttpServletRequest session) {
        Pasien pasien = (Pasien) session.getSession().getAttribute("userLogin");
        System.out.println(pasien.getIdPasien());
        JadwalPilihanPasien jadwalOptional = jadwalPilihanPasienRepository.findByEmailPasien(pasien.getEmail());
        if (jadwalOptional != null) {
            model.addAttribute("selectedJadwal", jadwalOptional);
            return "prevjadwal";
        } else {
            return "pasienDash";
        }
    }

    @GetMapping("/kelolaJadwalPilihan")
    public String kelolaPilihan(Model model, HttpServletRequest session) {
        Admin admin = (Admin) session.getSession().getAttribute("userLogin");
        List<JadwalPilihanPasien> jadwalPilihanPasienList = jadwalPilihanPasienRepository.findAll();
        if (admin != null) {
            model.addAttribute("jadwalPilihanPasienList", jadwalPilihanPasienList);
            return "kelolaPilihan";
        } else {
            return "adminDash";
        }
    }

    @PostMapping("/hapusJadwalPasien")
    public String hapusJadwalPilihanPasien(HttpServletRequest session) {
        Pasien pasien = (Pasien) session.getSession().getAttribute("userLogin");
        JadwalPilihanPasien jadwalPilihanPasien = pasien.getJadwalPilihanPasien();
        
        if (jadwalPilihanPasien != null) {

            pasien.setJadwalPilihanPasien(null);
            
            pasienRepo.save(pasien);
            
            jadwalPilihanPasienRepository.delete(jadwalPilihanPasien);
        }
        
        return "redirect:/pasienDash";
    }
}
