
package com.main.repository;


import com.main.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    public List<Author> findAllByFirstNameStartingWith(String prefix);
    public List<Author> findByFirstNameEndingWith(String suffix);
    public List<Author> findByFirstNameContaining(String infix);
    public List<Author> findByYearBornBetweenOrderByFirstName(int start,int end);
    public List<Author> findByYearBornBefore(int year);
    @Query("Select AVG(a.yearBorn) From Author a")
    public int getAverageYearBorn();
}
