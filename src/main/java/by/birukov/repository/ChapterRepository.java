package by.birukov.repository;

import by.birukov.entity.Chapter;
import by.birukov.entity.Fanfic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

//    @Autowired
//    SessionFactory session;

//    public default List<Chapter> getAllFanficChapters(Fanfic fanfic){
//        Query query = session.openSession();

//    }

    List<Chapter> findByFanfic(Fanfic fanfic);
}
