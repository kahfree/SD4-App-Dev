
package com.main.controllers;
import com.main.service.AuthorService;
import com.main.model.Author;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    @GetMapping("/authors")
    public List<Author> getAll() {
        return authorService.findAll();
    }
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getOne(@PathVariable long id) {
       Optional<Author> o =  authorService.findOne(id);
       
       if (!o.isPresent()) 
            return new ResponseEntity(HttpStatus.NOT_FOUND);
         else 
            return ResponseEntity.ok(o.get());
    }
    
    @GetMapping("/authors/count")
    public long getCount() {
        return authorService.count();
    }
    
    @DeleteMapping("/authors/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        authorService.deleteByID(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/authors/")
    public ResponseEntity add(@RequestBody Author a) {
        authorService.saveAuthor(a);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/authors/")
    public ResponseEntity edit(@RequestBody Author a) {
        authorService.saveAuthor(a);
        return new ResponseEntity(HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////////////////
    @GetMapping("/authors/startswith/{prefix}")
    public List<Author> startsWith(@PathVariable String prefix) {
        return authorService.findFirstNameStartsWith(prefix);
    }

    @GetMapping("/authors/endswith/{suffix}")
    public List<Author> endsWith(@PathVariable String suffix) {
        return authorService.findFirstNameEndsWith(suffix);
    }

    @GetMapping("/authors/containing/{infix}")
    public List<Author> containing(@PathVariable String infix) {
        return authorService.findFirstNameContaining(infix);
    }

    @GetMapping("/authors/between/{start}/{end}")
    public List<Author> startsWith(@PathVariable int start,@PathVariable int end) {
        return authorService.betweenYearBornOrderedByFirstName(start,end);
    }

    @GetMapping("/authors/bornbefore/{year}")
    public List<Author> bornbefore(@PathVariable int year) {
        return authorService.bornBefore(year);
    }

    @GetMapping("/authors/average/yearborn")
    public int averageYearBorn() {
        return authorService.averageYearBorn();
    }
}