package com.survei.dtos;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PertanyaanDto {
    
    private Long id;

    @NotEmpty(message = "deskripsi harus diisi")
    private String deskripsi;
}
