package by.birukov.service.impl;

import by.birukov.entity.Chapter;
import by.birukov.entity.Fanfic;
import by.birukov.repository.ChapterRepository;
import by.birukov.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterRepository repository;

    @Override
    public void createChapter(Chapter chapter) {
        repository.save(chapter);
    }

    @Override
    public Chapter getChapter() {
        return null;
    }

    @Override
    public List<Chapter> getAllFanficChapters(Fanfic fanfic){
        return repository.findByFanfic(fanfic);
    }
}
