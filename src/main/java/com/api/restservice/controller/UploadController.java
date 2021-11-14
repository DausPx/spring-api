package com.api.restservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
public class UploadController {
    
    @PostMapping("image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    
}
