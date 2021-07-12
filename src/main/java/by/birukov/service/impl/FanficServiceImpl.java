package by.birukov.service.impl;

import by.birukov.dto.FanficDto;
import by.birukov.entity.Fanfic;
import by.birukov.repository.FanficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FanficServiceImpl {

    @Autowired
    private FanficRepository fanficRepository;

    public Fanfic findByTitle(String title){
        return fanficRepository.findByTitle(title);
    }

    public List<FanficDto> findAll(){
        List<Fanfic> entities = fanficRepository.findAll();
        List<FanficDto> dtos = new ArrayList<>();

        for (Fanfic entityFanfic:
                entities) {
            FanficDto dto = new FanficDto();
            dto.setId(entityFanfic.getId());
            dto.setFandom(entityFanfic.getFandom().getFandom());
            dto.setAuthor(entityFanfic.getAuthor().getUsername());
            dto.setTitle(entityFanfic.getTitle());
            dto.setDate(entityFanfic.getDate());
            dto.setDescription(entityFanfic.getDescription());
            dto.setAuthorAvatar(entityFanfic.getAuthor().getAvatar());
            dtos.add(dto);
        }
        return dtos;
    }
}
