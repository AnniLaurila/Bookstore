package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
    @Test
    public void testCreateNewCategory() {
    	Category category1 = new Category("Lasten kirjat");
    	repository.save(category1);
    	assertThat(category1.getCategoryId()).isNotNull();
    } 
    
    @Test
    public void testDeleteCategory() {
    	Category category1 = new Category("Lasten kirjat");
    	repository.save(category1);
    	repository.delete(category1);
    	Optional<Category> category2 = repository.findById(category1.getCategoryId());
    	assertTrue(category2.isEmpty());
    } 

    @Test
    public void testSearchCategory() {
    	Category category1 = new Category("Lasten kirjat");
    	repository.save(category1);
    	Optional<Category> category2 = repository.findById(category1.getCategoryId());
    	assertTrue(category2.isPresent());
    } 

}
