package by.birukov.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class FanficDto implements Serializable {
    private int id;
//    @DateTimeFormat(pattern = "Yyyy-mm-dd HH:mm:ss")
//    @JsonFormat(pattern = "Yyyy-mm-dd HH:mm:ss")
    private Date date;
    private String title;
    private String author;
    private String fandom;
    private String description;
    private String authorAvatar;
}
