package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Otp;
import com.pragma.powerup.domain.spi.IOtpPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpUseCaseTest {

    @Mock
    private IOtpPersistencePort otpPersistencePort;

    private OtpUseCase otpUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        otpUseCase = new OtpUseCase(otpPersistencePort);
    }

    @Test
    void testSendOtp_generatesOtpAndSendsMessage() {
        // Arrange: Creamos un objeto Otp con el teléfono del cliente.
        String phone = "+1234567890";
        Otp otp = new Otp();
        otp.setPhone(phone);

        // Act: Invocamos el use case.
        Otp result = otpUseCase.sendOtp(otp);

        // Assert: Verificamos que se haya generado el OTP y el mensaje.
        assertNotNull(result.getOtp(), "El OTP no debe ser nulo");
        assertEquals(4, result.getOtp().length(), "El OTP debe tener 4 dígitos");
        String expectedMessage = "Tu código de seguridad es: " + result.getOtp();
        assertEquals(expectedMessage, result.getMessage(), "El mensaje debe construirse correctamente");
        assertEquals(phone, result.getPhone(), "El teléfono debe permanecer sin cambios");

        // Verificamos que se haya llamado al puerto de persistencia una única vez con el objeto Otp.
        verify(otpPersistencePort, times(1)).sendOtp(result);
    }
}