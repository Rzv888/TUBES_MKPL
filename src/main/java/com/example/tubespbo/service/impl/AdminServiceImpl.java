package com.example.tubespbo.service.impl;

import com.example.tubespbo.model.Admin;
import com.example.tubespbo.repository.AdminRepository;
import com.example.tubespbo.util.BaseResponse;

import com.example.tubespbo.dto.request.LoginRequest;
import com.example.tubespbo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repository;

    @Override
    public boolean login(LoginRequest request, BaseResponse<String> baseResponse) {
        System.out.println(request.getEmail() + " " + request.getPassword());
        Optional<Admin> usersOptional = repository.findByEmailAndPassword(request.getEmail(), request.getPassword());

        System.out.println(usersOptional.isPresent());
        return usersOptional.isPresent();
    }
}
