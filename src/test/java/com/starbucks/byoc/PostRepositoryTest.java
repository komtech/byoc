package com.starbucks.byoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PostRepositoryTest {

//	@Autowired
//	PostRepository repository;
	
	@Test
	public void test() {
	/*	Customer post = new Customer();
		post.setPostDate(new Date());
		post.setTitle("First Post My Own MYSQL");
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getTitle());*/
	}

}
