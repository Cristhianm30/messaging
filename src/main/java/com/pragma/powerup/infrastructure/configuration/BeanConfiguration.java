package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IOtpServicePort;
import com.pragma.powerup.domain.spi.IOtpPersistencePort;
import com.pragma.powerup.domain.usecase.OtpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IOtpServicePort otpServicePort(IOtpPersistencePort otpPersistencePort) {
        return new OtpUseCase(otpPersistencePort);
    }
}