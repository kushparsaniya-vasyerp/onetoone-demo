package dev.kush.onetoone.controller;

import dev.kush.onetoone.dto.AppendFileDto;
import dev.kush.onetoone.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController()
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file){
        return fileService.uploadFile(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName){
        return fileService.downloadFile(fileName);
    }

    @PostMapping("/append")
    public ResponseEntity<String> appendFile(@RequestBody AppendFileDto appendFileDto){
        return fileService.appendFile(appendFileDto);
    }
}
