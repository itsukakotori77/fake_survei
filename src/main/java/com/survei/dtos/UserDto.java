package com.survei.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.survei.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
    
    private Long id;

    @NotEmpty(message = "username harus diisi")
    private String username;

    @NotEmpty(message = "email harus diisi")
    private String email;
    
    @NotEmpty(message = "password harus diisi")
    private String password;
    
    @NotEmpty(message = "roles harus diisi")
    private String roles;

    @NotNull(message = "status harus diisi")
    private Boolean status;
}
