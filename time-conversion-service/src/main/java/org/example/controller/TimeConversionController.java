package org.example.controller;

import org.example.exceptions.InvalidTimeFormatException;
import org.example.service.TimeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeConversionController {

    @Autowired
    private TimeConversionService timeConversionService;

    @GetMapping("/convertTimeToWords")
    public String convertTimeToWords(@RequestParam String time){
        try{
            return timeConversionService.convertTimeToWords(time);
        }
        catch (InvalidTimeFormatException e){
            return "Invalid time format: " + e.getMessage();
        }
    }
}
