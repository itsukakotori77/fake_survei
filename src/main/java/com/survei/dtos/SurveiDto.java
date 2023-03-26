package com.survei.dtos;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SurveiDto {
    
    private Long id;

    @NotNull(message = "jumlah responden harus diisi")
    private Integer jumlah_responden;

    @NotNull(message = "tanggal awal harus diisi")
    private Date tanggal_awal;

    @NotNull(message = "tanggal akhir harus diisi")
    private Date tanggal_akhir;

    @NotNull(message = "status harus diisi")
    private Integer status;
}
