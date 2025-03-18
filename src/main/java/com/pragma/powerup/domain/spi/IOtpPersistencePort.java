package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Otp;

public interface IOtpPersistencePort {
    void sendOtp(Otp otp);
}
