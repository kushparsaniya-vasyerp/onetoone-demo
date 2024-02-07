package dev.kush.onetoone.service.impl;

import dev.kush.onetoone.dto.AppendFileDto;
import dev.kush.onetoone.exception.UploadFileException;
import dev.kush.onetoone.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@Service
public class FileServiceImpl implements FileService {

//    @Value("${upload.dir}")
    private static final String UPLOAD_DIR = "C:\\Users\\kushparsaniya\\Desktop\\upload";

    @Override
    public ResponseEntity<String> uploadFile(MultipartFile file) {
        try {
            File directory = new File(UPLOAD_DIR);

            if (!directory.exists()){
                directory.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);

            Files.write(filePath,file.getBytes(), CREATE);

            String downloadUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/laptop/download/")
                    .path(fileName)
                    .toUriString();
            return ResponseEntity.ok("successfully uploaded file here is download link : " + downloadUrl);
        } catch (Exception e) {
            throw  new UploadFileException("could not upload file ");
        }
    }

    @Override
    public ResponseEntity<?> downloadFile(String fileName) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
            File file = filePath.toFile();

            if (file.exists()){

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment",fileName);

                return new ResponseEntity<>(new FileSystemResource(file), headers,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("file not found",HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            throw new UploadFileException("could not download file " + fileName);
        }
    }

    @Override
    public ResponseEntity<String> appendFile(AppendFileDto appendFileDto) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(appendFileDto.fileName()).normalize();

            if (!Files.exists(filePath)) {
                throw new UploadFileException("File not found.");
            }


            Files.write(filePath, appendFileDto.content().getBytes(), APPEND);
            return ResponseEntity.ok("successfully appended file");
        } catch (Exception e) {
            throw new UploadFileException("could not write file ");
        }

    }

}
