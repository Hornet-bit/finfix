package by.birukov.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String password;
    private String avatar;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "fandoms",
            joinColumns = { @JoinColumn(name = "id") }
//            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private List<Fandom> fandoms;
}
