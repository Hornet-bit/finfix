package by.birukov.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FanficDto implements Serializable {
    private int id;
    private String date;
    private String title;
    private String author;
    private String fandom;
    private String description;
}
