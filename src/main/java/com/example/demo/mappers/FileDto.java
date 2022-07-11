package com.example.demo.mappers;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileDto {

    private MultipartFile file;

    private String nameFile;

}
