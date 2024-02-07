package dev.kush.onetoone.service;

import dev.kush.onetoone.dto.AppendFileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResponseEntity<String> uploadFile(MultipartFile file);

    ResponseEntity<?> downloadFile(String fileName);

    ResponseEntity<String> appendFile(AppendFileDto appendFileDto);
}
