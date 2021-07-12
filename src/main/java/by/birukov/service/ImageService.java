package by.birukov.service;

import by.birukov.dto.UploadDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    UploadDto upload(MultipartFile file);
}
