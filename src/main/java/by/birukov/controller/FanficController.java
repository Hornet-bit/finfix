package by.birukov.controller;

import by.birukov.dto.FanficDto;
import by.birukov.entity.Fanfic;
import by.birukov.service.impl.FanficServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FanficController {

    @Autowired
    private FanficServiceImpl fanficService;

    @GetMapping("/fanfics/{title}")
    public Fanfic findByTitle(@PathVariable("title") String title){
        return fanficService.findByTitle(title);
    }

    @GetMapping("/fanfics")
    public List<FanficDto> findAllFanfics(){
        return fanficService.findAll();
    }

    @PostMapping("/fanfics/new")
    public void createFanfic(){

    }
}
