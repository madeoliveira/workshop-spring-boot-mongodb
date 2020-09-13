package com.training.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.training.workshopmongo.domain.Post;
import com.training.workshopmongo.domain.User;
import com.training.workshopmongo.dto.AuthorDTO;
import com.training.workshopmongo.repository.PostRepository;
import com.training.workshopmongo.repository.UserRepository;

@Configuration
public class instantiation implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	    Post post1 = new Post(null, sdf.parse("21/03/2018"), "Start the jorney","I will travel to São Paulo", new AuthorDTO(maria));
	    Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good Morning","I woke up happy today!",new AuthorDTO(maria));
	    
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}
	
}
