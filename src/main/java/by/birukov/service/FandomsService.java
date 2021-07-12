package by.birukov.service;

import by.birukov.entity.Fandom;

import java.io.Serializable;
import java.util.List;

public interface FandomsService extends Serializable {
    List<Fandom> getUserFandoms(List<String> fandomsStr);
}
