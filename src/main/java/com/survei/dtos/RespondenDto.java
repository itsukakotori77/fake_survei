package com.survei.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RespondenDto {
    
    private Long id;

    @NotEmpty(message = "usia harus diisi")
    private String usia;

    @NotNull(message = "jenis kelamin harus diisi")
    private Integer jenis_kelamin;
}
