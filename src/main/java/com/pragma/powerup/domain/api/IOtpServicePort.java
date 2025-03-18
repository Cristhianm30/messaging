package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Otp;

public interface IOtpServicePort {

    Otp sendOtp(Otp otp);
}
