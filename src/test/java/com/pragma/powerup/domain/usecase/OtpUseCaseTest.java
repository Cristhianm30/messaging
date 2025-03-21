package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Otp;
import com.pragma.powerup.domain.spi.IOtpPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OtpUseCaseTest {

    @Mock
    private IOtpPersistencePort otpPersistencePort;

    @InjectMocks
    private OtpUseCase otpUseCase;

    @Test
    void sendOtp_ShouldGenerate4DigitNumericOtp() {
        // Arrange
        Otp otpRequest = createValidOtpRequest();

        // Act
        Otp result = otpUseCase.sendOtp(otpRequest);

        // Assert
        assertThat(result.getOtp())
                .hasSize(4)
                .containsOnlyDigits();
    }

    @Test
    void sendOtp_ShouldIncludeOtpInMessage() {
        // Arrange
        Otp otpRequest = createValidOtpRequest();

        // Act
        Otp result = otpUseCase.sendOtp(otpRequest);

        // Assert
        assertThat(result.getMessage())
                .startsWith("Tu código de seguridad es: ")
                .endsWith(result.getOtp());
    }

    @Test
    void sendOtp_ShouldPersistOtpWithOriginalPhoneNumber() {
        // Arrange
        Otp otpRequest = createValidOtpRequest();

        // Act
        Otp result = otpUseCase.sendOtp(otpRequest);

        // Assert
        verify(otpPersistencePort).sendOtp(result);
        assertThat(result.getPhone()).isEqualTo(otpRequest.getPhone());
    }

    @Test
    void sendOtp_ShouldGenerateValidOtpRange() {
        // Arrange
        Otp otpRequest = createValidOtpRequest();

        // Act
        Otp result = otpUseCase.sendOtp(otpRequest);
        int numericOtp = Integer.parseInt(result.getOtp());

        // Assert
        assertThat(numericOtp).isBetween(0, 9999);
    }

    private Otp createValidOtpRequest() {
        Otp otp = new Otp();
        otp.setPhone("+573001234567");
        return otp;
    }
}