package by.birukov.controller;

import by.birukov.dto.UploadDto;
import by.birukov.entity.User;
import by.birukov.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
    private ImageService imageService;
//
    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
//
    @CrossOrigin
    @PostMapping("/upload")
    public UploadDto upload(@RequestParam MultipartFile image){
        return imageService.upload(image);
    }
//
//    @GetMapping
//    public String getImage(){
//        return null;
//    }
}
