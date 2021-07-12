package by.birukov.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "fandoms")
public class Fandom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fandom;
    @ManyToMany
    private List<User> users;
//    private
}
