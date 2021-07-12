package by.birukov.repository;

import by.birukov.entity.Fandom;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FandomRepository extends JpaRepository<Fandom, Integer> {

    Fandom findFandomsByFandom(String fandom);

}
