package com.survei.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.survei.dtos.JawabanDto;
import com.survei.entities.Jawaban;
import com.survei.services.JawabanService;
import com.survei.utility.ErrorParsingUtility;

@RestController
@RequestMapping("/v1/api/jawaban")
@PreAuthorize("isAuthenticated()")
public class JawabanController 
{
    @Autowired
    private JawabanService jawabanService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody JawabanDto dataDto, Errors errors)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>(); 

        if(errors.hasErrors()){
            map.put("code", "01");
            map.put("message", "validasi error");
            map.put("data", ErrorParsingUtility.parse(errors));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        try {
            Jawaban jawaban = modelMapper.map(dataDto, Jawaban.class);
            Jawaban dataSave = jawabanService.save(jawaban);
            
            if(dataSave != null){
                map.put("code", "00");
                map.put("message", "data berhasil ditambahkan");
                map.put("data", dataSave);

                return ResponseEntity.status(HttpStatus.OK).body(map);
            }

            map.put("code", "01");
            map.put("message", "data sudah tersedia");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
            
        } catch (Exception e) {
            map.put("code", "01");
            map.put("message", "terjadi kesalahan pada proses input data");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @GetMapping
    public ResponseEntity<?> all()
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Iterable<Jawaban> list = jawabanService.findAll();

        map.put("code", "00");
        map.put("message", "data berhasil ditampilkan");
        map.put("data", list);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Jawaban data = jawabanService.findOne(id);
        if(data != null){
            map.put("code", "00");
            map.put("message", "data berhasil ditemukan");
            map.put("data", data);

            return ResponseEntity.status(HttpStatus.OK).body(map);
        }
        
        map.put("code", "01");
        map.put("message", "data tidak ditemukan");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody JawabanDto dataDto, Errors errors)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>(); 

        if(errors.hasErrors()){
            map.put("code", "01");
            map.put("message", "validasi error");
            map.put("data", ErrorParsingUtility.parse(errors));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        try {
            Jawaban responden = modelMapper.map(dataDto, Jawaban.class);
            Jawaban dataSave = jawabanService.save(responden);
            
            map.put("code", "00");
            map.put("message", "data berhasil diubah");
            map.put("data", dataSave);

            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            map.put("code", "01");
            map.put("message", "terjadi kesalahan pada proses input data");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteData(@RequestBody JawabanDto dataDto)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        try {
            jawabanService.removeOne(dataDto.getId());
            map.put("code", "00");
            map.put("message", "data berhasil dihapus");

            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            map.put("code", "01");
            map.put("message", "terjadi kesalahan pada proses hapus data");

            return ResponseEntity.status(HttpStatus.OK).body(map);
        }
    }
}
