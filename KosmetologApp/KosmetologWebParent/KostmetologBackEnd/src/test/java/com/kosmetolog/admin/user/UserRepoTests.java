package com.kosmetolog.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.kosmetolog.entity.Role;
import com.kosmetolog.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTests {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userVlad = new User("lean20012003@gmail.com", "vlad2020", "vlad", "didenko");
		userVlad.addRole(roleAdmin);
		
		User savedUser = repo.save(userVlad);
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateUserWithTwoRoles() {
		
		User userSlava = new User("Slava@gmail.com", "slava2020", "slava", "antonov");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		userSlava.addRole(roleEditor);
		userSlava.addRole(roleAssistant);
		
		User savedUser = repo.save(userSlava);
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
		
	}
	
	@Test
	public void testGetUserById() {
		User userVlad = repo.findById(1).get();
		System.out.println(userVlad);
		assertThat(userVlad).isNotNull();
		
	}
	
	@Test
	public void testUpdateUserDetails() {
		User userVlad = repo.findById(1).get();
		userVlad.setEnabled(true);
		userVlad.setEmail("gogole@gmail.com");
		
		repo.save(userVlad); 
		
	}
	
	@Test
	public void testUpdateUserRoles() {
		User userSlava = repo.findById(2).get();
		Role roleEditor = new Role(3);
		Role roleSalesperson = new Role(2);
		
		userSlava.getRoles().remove(roleEditor);
		userSlava.addRole(roleSalesperson);
		repo.save(userSlava); 
		
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId =2;
		repo.deleteById(userId);
		
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "gogole@gmail.com";
		User user = repo.getUserByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
}
