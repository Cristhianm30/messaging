package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.OtpRequestDto;
import com.pragma.powerup.application.dto.response.OtpResponseDto;
import com.pragma.powerup.application.handler.IOtpHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messaging")
@AllArgsConstructor
public class MessagingRestController {

    private final IOtpHandler otpHandler;


    @PostMapping("/otp")
    public ResponseEntity<OtpResponseDto> sendOtp(@RequestBody OtpRequestDto otpRequestDto) {
        return ResponseEntity.ok(otpHandler.sendOtp(otpRequestDto));
    }
}
