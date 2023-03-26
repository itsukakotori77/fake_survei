package com.survei.utility;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Configuration
public class ErrorParsingUtility {
    
    public static Map<String, String> parse(Errors errors)
    {
        Map<String, String> data = new HashMap<>();
        errors.getAllErrors().forEach((error) -> {
            data.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return data;
    }
}
