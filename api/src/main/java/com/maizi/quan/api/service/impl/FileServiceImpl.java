package com.maizi.quan.api.service.impl;

import com.maizi.quan.api.service.FileService;
import com.maizi.quan.common.exception.ClientException;
import com.maizi.quan.manager.FileRepository;
import com.maizi.quan.manager.domain.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author create by fanwenhao
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileRepository fileRepository;

    @Override
    public String upload(MultipartFile multipartFile) {
        byte[] bytes;
        try {
            bytes = multipartFile.getBytes();
        } catch (IOException e) {
            log.warn("upload fail", e);
            throw new ClientException("上传失败");
        }

        File file = new File();
        file.setBytes(bytes);
        file.setName(multipartFile.getOriginalFilename());
        file.setType(multipartFile.getContentType());
        fileRepository.save(file);
        return file.getUuid();
    }

    @Override
    public void download(String uuid, HttpServletResponse response) {
        File file = fileRepository.get(uuid);
        try {
            response.setHeader("Content-Type", file.getType());
            byte[] content = file.getBytes();
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
        } finally {
        }
    }
}
