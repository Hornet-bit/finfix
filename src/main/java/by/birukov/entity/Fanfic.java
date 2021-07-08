package by.birukov.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "fanfics")
public class Fanfic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String title;
    private String description;
    private String picture;

    @ManyToOne
    private User author;

    @ManyToOne
    private Fandom fandom;

}
