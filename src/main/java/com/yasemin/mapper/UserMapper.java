package com.yasemin.mapper;

import com.yasemin.dto.request.RegisterRequestDto;
import com.yasemin.dto.response.LoginResponseDto;
import com.yasemin.dto.response.RegisterResponseDto;
import com.yasemin.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginResponseDto fromUserToLoginResponseDto(final User user);

    RegisterResponseDto fromUserToRegisterResponseDto(final User user);
    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);
}
