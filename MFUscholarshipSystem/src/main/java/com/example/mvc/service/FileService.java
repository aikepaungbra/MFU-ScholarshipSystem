package com.example.mvc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class FileService {

        public static String convertFileToBase64(MultipartFile file) {
            if (file == null || file.isEmpty()) {
                throw new IllegalArgumentException("File cannot be null or empty");
            }

            String fileName = file.getOriginalFilename();
            if (fileName != null && fileName.contains("..")) {
                System.out.println("File name contains invalid path sequence");
            }

            try {
                return Base64.getEncoder().encodeToString(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to convert file to Base64", e);
            }
        }


}
