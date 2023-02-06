package com.main.service;


import com.main.model.Author;
import com.main.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    public Optional<Author> findOne(Long id) {
        return authorRepo.findById(id);
    }

    public List<Author> findAll() {
        return (List<Author>) authorRepo.findAll();
    }

    public long count() {
        return authorRepo.count();
    }

    public void deleteByID(long authorID) {
        authorRepo.deleteById(authorID);
    }

    public void saveAuthor(Author a) {
        authorRepo.save(a);
    }

    public List<Author> findFirstNameStartsWith(String prefix){ return authorRepo.findAllByFirstNameStartingWith(prefix); }

    public List<Author> findFirstNameEndsWith(String suffix){return authorRepo.findByFirstNameEndingWith(suffix);}

    public List<Author> findFirstNameContaining(String infix){return authorRepo.findByFirstNameContaining(infix);}

    public List<Author> betweenYearBornOrderedByFirstName(int start,int end){return authorRepo.findByYearBornBetweenOrderByFirstName(start,end);}

    public List<Author> bornBefore(int year){return authorRepo.findByYearBornBefore(year);}

    public int averageYearBorn(){return authorRepo.getAverageYearBorn();}

}//end class