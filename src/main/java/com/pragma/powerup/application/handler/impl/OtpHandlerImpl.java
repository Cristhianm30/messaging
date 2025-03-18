package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.OtpRequestDto;
import com.pragma.powerup.application.dto.response.OtpResponseDto;
import com.pragma.powerup.application.handler.IOtpHandler;
import com.pragma.powerup.application.mapper.IOtpRequestMapper;
import com.pragma.powerup.application.mapper.IOtpResponseMapper;
import com.pragma.powerup.domain.api.IOtpServicePort;
import com.pragma.powerup.domain.model.Otp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OtpHandlerImpl implements IOtpHandler {

    private final IOtpServicePort otpServicePort;
    private final IOtpRequestMapper otpRequestMapper;
    private final IOtpResponseMapper otpResponseMapper;


    @Override
    public OtpResponseDto sendOtp(OtpRequestDto otpRequestDto) {

        Otp otp = otpRequestMapper.toObject(otpRequestDto);
        Otp createOtp = otpServicePort.sendOtp(otp);

        return otpResponseMapper.toResponse(createOtp);
    }
}
