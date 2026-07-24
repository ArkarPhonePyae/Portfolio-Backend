package com.demo.portfolio.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:4200")
public class ResumeController {

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadResume() {
        try {
            Path path = Paths.get("src/main/resources/static/Arkar_Resume.pdf");
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Arkar_Phone_Pyae_Resume.pdf\"")
                        .body(resource);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }
}