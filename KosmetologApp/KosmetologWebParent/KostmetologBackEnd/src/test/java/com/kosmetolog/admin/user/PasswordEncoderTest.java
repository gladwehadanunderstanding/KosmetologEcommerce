package com.kosmetolog.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.booleanThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	@Test
	public void testEncodePassword() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "vlad2020";
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		
		System.out.println(encodedPassword);
		
		boolean matches = bCryptPasswordEncoder.matches(password, encodedPassword);
		assertThat(matches).isTrue();
	}
	
}
