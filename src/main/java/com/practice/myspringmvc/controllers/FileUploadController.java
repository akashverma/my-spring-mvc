package com.practice.myspringmvc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("Uploaded" + file.getOriginalFilename());
        return "Uploaded" + file.getOriginalFilename();
    }

    @PostMapping("/convert")
    public void convert(@RequestParam("file") MultipartFile file) {
        //
    }
}
