package com.maizi.quan.api.controller;

import com.maizi.quan.api.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * @Author create by fanwenhao
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/api/file/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }

    @GetMapping("/api/file/download")
    public void download(@RequestParam("uuid") String uuid, HttpServletResponse response) {
        fileService.download(uuid, response);
    }
}
