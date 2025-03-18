package com.pragma.powerup.infrastructure.out.twilio;


import com.pragma.powerup.domain.exception.ErrorSendingSmsException;
import com.pragma.powerup.domain.model.Otp;
import com.pragma.powerup.domain.spi.IOtpPersistencePort;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class TwilioAdapter implements IOtpPersistencePort {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void sendOtp(Otp otp) {
        try {
            Message.creator(
                    new PhoneNumber("whatsapp:"+otp.getPhone()),
                    new PhoneNumber("whatsapp:"+twilioPhoneNumber),
                    otp.getMessage()
            ).create();
        } catch (ApiException e) {
            throw new ErrorSendingSmsException();
        }
    }
}