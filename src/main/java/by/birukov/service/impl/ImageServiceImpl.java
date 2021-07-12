package by.birukov.service.impl;

import by.birukov.dto.UploadDto;
import by.birukov.service.ImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    Map result;
    UploadDto dto = new UploadDto();
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public UploadDto upload(MultipartFile image) {
        try {
//            cloudinary.uploader().upload(image,
//                    ObjectUtils.emptyMap());
            File file = File.createTempFile("name", "prefix");
            image.transferTo(file);
            result = cloudinary.uploader().upload(file,
                    ObjectUtils.asMap("puc_id", "ds"));

            dto.setUrl((String) result.get("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return dto;
    }

//    private final Cloudinary cloudinary;
}
