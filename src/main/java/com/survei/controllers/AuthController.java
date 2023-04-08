package com.survei.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.survei.dtos.LoginDto;
import com.survei.dtos.SignUpDto;
import com.survei.entities.User;
import com.survei.security.jwt.JwtUtils;
import com.survei.services.UserService;

@RestController
@RequestMapping("/v1/auth")
public class AuthController 
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired    
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto request)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtils.generateJwtToken(authentication);
            // UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
            // JwtResponseDto jwtResponse = new JwtResponseDto(token, principal.getUsername(), principal.getEmail());
    
            map.put("code", "00");
            map.put("message", "login berhasil");
            map.put("token", token);
    
            return ResponseEntity.status(HttpStatus.OK).body(map);
            
        } catch (Exception e) {
            map.put("code", "01");
            map.put("message", "terjadi kesalahan para proses login");
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpDto request)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>(); 

        try {
            User user = modelMapper.map(request, User.class);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRoles("user");
            user.setStatus(true);
            User created = userService.save(user);

            map.put("code", "00");
            map.put("message", "berhasil register");
            map.put("data", created);

            return ResponseEntity.status(HttpStatus.OK).body(map);
            
        } catch (Exception e) {
            map.put("code", "01");
            map.put("message", "terjadi kesalahan pada proses penambahan data");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

}
