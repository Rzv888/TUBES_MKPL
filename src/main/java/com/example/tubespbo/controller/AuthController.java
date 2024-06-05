package com.example.tubespbo.controller;

import com.example.tubespbo.dto.request.LoginRequest;
import com.example.tubespbo.dto.request.SignupRequest;
import com.example.tubespbo.model.Admin;
import com.example.tubespbo.model.Pasien;
import com.example.tubespbo.repository.AdminRepository;
import com.example.tubespbo.repository.PasienRepository;
import com.example.tubespbo.service.AdminService;
import com.example.tubespbo.service.PasienService;
import com.example.tubespbo.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasienService pasienService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private PasienRepository pasienRepo;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login-request")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model, HttpServletRequest session) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        if (pasienService.login(loginRequest, baseResponse)) {
            Optional<Pasien> pasienOptional = pasienRepo.findByEmail(loginRequest.getEmail());
            Pasien pasien = pasienOptional.get();
            System.out.println(pasien.getEmail());
            session.getSession().setAttribute("userLogin", pasien);
            if (pasien.getJadwalPilihanPasien() == null) {
                return "redirect:/pasienDash";
            }else{
                return "redirect:/preview";
            }
        } else if (adminService.login(loginRequest, baseResponse)) {
            Optional<Admin> adminOptional = adminRepo.findByEmail(loginRequest.getEmail());
            Admin admin = adminOptional.get();
            System.out.println(admin.getEmail());
            session.getSession().setAttribute("userLogin", admin);
            // Rest of your code here
            System.out.println("cekkk");
            return "redirect:/adminDash";
        } else {
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("signupRequest", new SignupRequest());
        return "signup";
    }

    @PostMapping("/signup-request")
    public String signup(@ModelAttribute SignupRequest signupRequest, Model model) {
        BaseResponse<String> baseResponse = new BaseResponse<>();
        if (pasienService.signup(signupRequest, baseResponse)) {
            return "redirect:/auth/login";
        }
        model.addAttribute("success", false);
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest session) {
        session.getSession().invalidate();
        return "redirect:/auth/login";
    }
}