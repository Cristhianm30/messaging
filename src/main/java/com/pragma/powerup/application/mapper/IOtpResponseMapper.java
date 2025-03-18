package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.OtpResponseDto;
import com.pragma.powerup.domain.model.Otp;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOtpResponseMapper {

    OtpResponseDto toResponse(Otp otp);

}
