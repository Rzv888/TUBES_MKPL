package com.example.tubespbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tubespbo.model.Admin;
import com.example.tubespbo.model.JadwalKerja;
import com.example.tubespbo.model.Pasien;
import com.example.tubespbo.repository.AdminRepository;
import com.example.tubespbo.repository.JadwalKerjaRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JadwalKerjaController {
    @Autowired
    private JadwalKerjaRepository jadwalKerjaRepository;

    @Autowired
    private AdminRepository adminRepo;

    @GetMapping("/pasienDash")
    public String getJadwalKerja(Model model, HttpServletRequest request) {
        List<JadwalKerja> jadwalKerjaList = jadwalKerjaRepository.findAll();
        Pasien pasien = (Pasien) request.getSession().getAttribute("userLogin");
        if (pasien != null) {
            model.addAttribute("jadwalKerjaList", jadwalKerjaList);
            model.addAttribute("null", (int) 0);
            return "pasienDash";
        } else {
            return "login";
        }
    }

    @GetMapping("/adminDash")
    public String admin(Model model, HttpServletRequest request) {
        List<JadwalKerja> jadwalKerjaList = jadwalKerjaRepository.findAll();
        Admin admin = (Admin) request.getSession().getAttribute("userLogin");
        if (admin != null) {
            model.addAttribute("jadwalKerjaList", jadwalKerjaList);
            return "adminDash";
        } else {
            return "login";
        }
    }

    @GetMapping("/hapus/{id}")
    public String hapusJadwal(@PathVariable("id") int id) {
        // Lakukan logika penghapusan berdasarkan ID jadwal yang diterima
        jadwalKerjaRepository.deleteById(id);
        return "redirect:/tambahJadwal"; // Arahkan kembali ke halaman jadwal kerja
    }

    @GetMapping("/tambahJadwal")
    public String tambahJadwal(Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("userLogin");
        if (admin != null) {
            model.addAttribute("tanggalKerja", "");
            model.addAttribute("jamMulai", "");
            model.addAttribute("jamSelesai", "");
            model.addAttribute("department", "");
            model.addAttribute("namaDokter", "");
            return "tambahJadwal";
        } else {
            return "login";
        }
    }

    @PostMapping("/addJadwal")
    public String addJadwal(@RequestParam("tanggalKerja") String tanggal, @RequestParam("jamMulai") String jamMulai,
            @RequestParam("jamSelesai") String jamSelesai, @RequestParam("department") String department,
            @RequestParam("namaDokter") String namaDokter, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("userLogin");
        if (admin != null) {
            // Mendapatkan list yang ada di model
            JadwalKerja jadwalKerja = new JadwalKerja(department, tanggal, namaDokter, jamMulai, jamSelesai);
            jadwalKerja.setAdmin(admin);
            admin.setKerjaList(jadwalKerja);
            adminRepo.save(admin);
            admin.resetKerjaList();
            return "redirect:/tambahJadwal";
        } else {
            return "login";
        }
    }

}
