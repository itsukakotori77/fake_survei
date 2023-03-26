package com.survei.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_survei")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Survei implements Serializable{
    
    private final static Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jumlah_responden", length = 4, nullable = false)
    private Integer jumlah_responden;

    @Column(name = "tanggal_awal", nullable = false)
    private Date tanggal_awal;

    @Column(name = "tanggal_akhir", nullable = false)
    private Date tanggal_akhir;

    @Column(name = "status", length = 1, nullable = false)
    private Integer status;

    @JsonIgnore
    @CreationTimestamp
    private Date created_at;
    
    @JsonIgnore
    @UpdateTimestamp
    private Date updated_at;



}
