package by.birukov.service.impl;

import by.birukov.entity.Fandom;
import by.birukov.repository.FandomRepository;
import by.birukov.service.FandomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FandomServiceImpl implements FandomsService {
    @Autowired
    FandomRepository fandomRepository;
    @Override
    public List<Fandom> getUserFandoms(List<String> fandomsStr) {
        List<Fandom> fandoms = new ArrayList<>();
        for (String f:fandomsStr) {
            fandoms.add(fandomRepository.findFandomsByFandom(f));
        }
        return fandoms;
    }
}
