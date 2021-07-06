package by.birukov.repository;

import by.birukov.entity.Fanfic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FanficRepository extends JpaRepository<Fanfic, Integer> {

    Fanfic findByTitle(String title);

    @Override
    List<Fanfic> findAll();
}
