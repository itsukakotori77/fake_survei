package com.survei.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_pertanyaan")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pertanyaan implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deskripsi", length = 50, nullable = false)
    private String deskripsi;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @ManyToMany
    @JoinTable(name = "tbl_jawaban_pertanyaan", joinColumns = @JoinColumn(name = "pertanyaan_id"),
        inverseJoinColumns = @JoinColumn(name ="jawaban_id"))
    @JsonManagedReference
    private List<Jawaban> jawabans;
}
