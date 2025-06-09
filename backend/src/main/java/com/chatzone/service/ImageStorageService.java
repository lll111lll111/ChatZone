package com.chatzone.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageStorageService {

    @Value("${app.storage.image.upload-dir}")
    private String uploadDir;

    @Value("${app.storage.image.allowed-extensions}")
    private String allowedExtensions;

    @Value("${app.storage.image.base-url}")
    private String baseUrl; // 例如: http://localhost:8080/images/

    @PostConstruct
    public void init() throws IOException {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public void validateImage(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));

        if (!allowedExtensions.contains(fileExtension.toLowerCase())) {
            throw new IllegalArgumentException("不支持的文件类型");
        }
    }

    /**
     * 存储图片并返回访问URL
     */
    public String storeImage(MultipartFile file) throws IOException {
        validateImage(file);

        // 生成唯一文件名
        String fileExtension = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName = UUID.randomUUID() + fileExtension;

        // 存储文件
        Path destination = Paths.get(uploadDir).resolve(newFileName);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        // 返回访问URL
        return baseUrl + newFileName;
    }
}
