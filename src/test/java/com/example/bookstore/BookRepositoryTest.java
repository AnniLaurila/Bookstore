package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
    @Test
    public void testCreateNewBook() {
    	Category category1 = new Category("Lasten kirjat");
    	Book book = new Book("Terve Tomppa", "Kristiina Louhi", 2007, "9789513101731", 16.7, category1);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
    
    @Test
    public void testDeleteBook() {
    	Category category1 = new Category("Lasten kirjat");
    	Book book = new Book("Terve Tomppa", "Kristiina Louhi", 2007, "9789513101731", 16.7, category1);
    	repository.save(book);
    	repository.delete(book);
    	Optional<Book> book2 = repository.findById(book.getId());
    	assertTrue(book2.isEmpty());
    } 

    @Test
    public void testSearchBook() {
    	Category category1 = new Category("Lasten kirjat");
    	Book book = new Book("Terve Tomppa", "Kristiina Louhi", 2007, "9789513101731", 16.7, category1);
    	repository.save(book);
    	Optional<Book> book2 = repository.findById(book.getId());
    	assertTrue(book2.isPresent());
    } 
}
