package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
    @Test
    public void testCreateNewUser() {
		User user1 = new User("testUser", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		repository.save(user1);
    	assertThat(user1.getId()).isNotNull();
    } 
    
    @Test
    public void testDeleteUser() {
    	User user1 = new User("testUser", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		repository.save(user1);
    	repository.delete(user1);
    	Optional<User> user2 = repository.findById(user1.getId());
    	assertTrue(user2.isEmpty());
    } 

    @Test
    public void testSearchUser() {
    	User user1 = new User("testUser", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		repository.save(user1);
    	Optional<User> user2 = repository.findById(user1.getId());
    	assertTrue(user2.isPresent());
    } 

}
