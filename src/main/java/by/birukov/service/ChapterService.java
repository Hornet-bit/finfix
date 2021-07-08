package by.birukov.service;

import by.birukov.entity.Chapter;
import by.birukov.entity.Fanfic;
import org.apache.commons.collections.Factory;

import java.util.List;

public interface ChapterService {

    void createChapter(Chapter chapter);

    Chapter getChapter();

    List<Chapter> getAllFanficChapters(Fanfic fanfic);
}
