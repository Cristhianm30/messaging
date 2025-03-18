package com.pragma.powerup.domain.model;

public class Otp {
    private String otp;
    private String message;
    private String phone;

    public Otp() {
    }

    public Otp(String otp, String message, String phone) {
        this.otp = otp;
        this.message = message;
        this.phone = phone;
    }

    // Getters y setters
    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
