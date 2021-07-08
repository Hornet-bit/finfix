package by.birukov.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "fanfics_chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String text;

    @Column(name = "chapter_number")
    private int chapterNumber;

//    @Column(name = "fanfic_id")
    @ManyToOne
    private Fanfic fanfic;

}
