package com.example.tubespbo.service;

import com.example.tubespbo.util.BaseResponse;

import com.example.tubespbo.dto.request.LoginRequest;

public interface AdminService {
    boolean login(LoginRequest request, BaseResponse<String> baseResponse);
}
