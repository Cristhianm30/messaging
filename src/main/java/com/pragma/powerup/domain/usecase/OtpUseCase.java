package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IOtpServicePort;
import com.pragma.powerup.domain.model.Otp;
import com.pragma.powerup.domain.spi.IOtpPersistencePort;
import java.util.Random;

public class OtpUseCase implements IOtpServicePort {

    private final IOtpPersistencePort otpPersistencePort;
    private static final Random RANDOM = new Random();

    public OtpUseCase(IOtpPersistencePort otpPersistencePort) {
        this.otpPersistencePort = otpPersistencePort;
    }

    @Override
    public Otp sendOtp(Otp otp) {

        String generatedOtp = String.format("%04d", RANDOM.nextInt(9999));
        otp.setOtp(generatedOtp);

        String message = "Tu código de seguridad es: " + generatedOtp;
        otp.setMessage(message);

        otpPersistencePort.sendOtp(otp);

        return otp;
    }
}