package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.OtpRequestDto;
import com.pragma.powerup.application.dto.response.OtpResponseDto;

public interface IOtpHandler {
    OtpResponseDto sendOtp(OtpRequestDto otpRequestDto);
}
