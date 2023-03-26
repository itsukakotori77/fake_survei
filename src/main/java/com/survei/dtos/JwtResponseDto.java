package com.survei.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class JwtResponseDto implements Serializable{

    private String token;

    private String type = "Bearer";

    private String username;
    
    private String email;

    public JwtResponseDto(String accessToken, String username, String email){
        this.username = username;
        this.email = email;
        this.token = accessToken;
    }
}
