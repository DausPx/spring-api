package com.api.restservice.controller;

import com.api.restservice.model.AmazonImage;
import com.api.restservice.service.amazonS3.AmazonS3ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
public class UploadController {

    @Autowired
    private AmazonS3ImageService amazonS3ImageService;
    
    @PostMapping("image/upload")
    public ResponseEntity<AmazonImage> insertImage(@RequestPart(value = "image") MultipartFile image) {
        return ResponseEntity.ok(getAmazonS3ImageService().uploadImageToAmazon(image));
    }

    public AmazonS3ImageService getAmazonS3ImageService() {
        return amazonS3ImageService;
    }
}
