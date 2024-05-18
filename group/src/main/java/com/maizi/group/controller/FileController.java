package com.maizi.group.controller;

import com.maizi.group.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
