package com.yasemin.dto.response;

import com.yasemin.utility.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {
    String name;
    String surname;
    String email;
    EStatus status;
}
