package com.example.springdata.demo;

import com.example.springdata.demo.model.User;
import com.example.springdata.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//https://docs.spring.io/spring-data/jpa/docs/2.6.0/reference/html/#preface
@SpringBootTest
class SpringdataTests {


	// current:
	// https://docs.spring.io/spring-data/jpa/docs/2.6.0/reference/html/#reference
	// Auditing:
	// https://blog.csdn.net/qq_40161813/article/details/126100653

	@Autowired
	UserRepository userRepository;

	@Test
	void testFindById() {
		Optional<User> userOptional =  userRepository.findById(3);
		User user = userOptional.get();
		System.out.println(user);
	}

	@Test
	void testQuery() {

		System.out.println("Test Find By Race Query:");
		List<User> users =  userRepository.findByRaceQuery("Lupo");
		users.forEach(System.out::println);

		System.out.println("Test Find By Name Query:");
		users =  userRepository.findByNameQuery("W");
		users.forEach(System.out::println);

		System.out.println("Test Find By Age Query:");
		users =  userRepository.findByAgeLarger(18);
		users.forEach(System.out::println);
	}

    @Test
    void testFindAll() {
        List<User> users =  userRepository.findAll();
        users.forEach(System.out::println);
    }

	@Test
	void testQueryFromMethodNames() {
		//https://docs.spring.io/spring-data/jpa/docs/2.6.0/reference/html/#repositories.query-methods.query-creation
		System.out.println("Test Find By Race OrderBy Age Asc:");
		List<User> users =  userRepository.findByRaceOrderByAgeAsc("Caprinae");
		users.forEach(System.out::println);
		System.out.println("Test Find By Race OrderBy Age Desc:");
		users =  userRepository.findByRaceOrderByAgeDesc("Lupo");
		users.forEach(System.out::println);
	}

	@Test
	void testPaging() {

		Pageable pageable = PageRequest.of(1,4);

		System.out.println("Test Paging:");
		Page<User> page =  userRepository.findAll(pageable);
		List<User> users = page.toList();
		users.forEach(System.out::println);

		System.out.println("Test Paging With Method Name:");
		page = userRepository.findBySex("male",pageable);
		users = page.toList();
		users.forEach(System.out::println);
	}

	@Test
	void testSorting() {
		System.out.println("Find All Sorting:");
		Sort sort = Sort.by(Sort.Order.asc("age"));
		List<User> users =  userRepository.findAll(sort);
		users.forEach(System.out::println);

		System.out.println("Query And Sorting:");
		users =  userRepository.findByAndSort("w",Sort.by("race"));
		users.forEach(System.out::println);
	}

	@Test
	void testQueryStream() {
		// You're trying to execute a streaming query method without a surrounding transaction that keeps the connection open
		//so that the Stream can actually be consumed. Make sure the code consuming the stream
		// uses @Transactional or any other way of declaring a (read-only) transaction.

		/*System.out.println("Test Find All By Race:");
		try (Stream<User> stream = userRepository.findAllByRace("Caprinae")) {
			stream.forEach(System.out::println);
		}

		System.out.println("Test Find All As Stream:");
		try (Stream<User> stream = userRepository.findAllAsStream()) {
			stream.forEach(System.out::println);
		}*/
	}

	@Test
	void testAsyncQuery() throws ExecutionException, InterruptedException {
		System.out.println("Asynchronous Query Results:");
		Future<User> future =  userRepository.findByName("Weslie");
		User user= future.get();
		System.out.println(user.toString());
	}

	@Test
	void testUpdate() throws ExecutionException, InterruptedException{
		System.out.println("Asynchronous Query Results:");
		userRepository.setFixedAgeFor(20,"Wilie");
		Future<User> future =  userRepository.findByName("Wilie");
		User user= future.get();
		System.out.println(user.toString());
	}

	@Test
	void testDelete() {
		System.out.println("Test Delete Results:");
		userRepository.deleteByName("Weslie");
		userRepository.deleteByIdQuery(2);
		List<User> users =  userRepository.findAll();
		users.forEach(System.out::println);
	}

	@Test
	void testMatcher() {
		System.out.println("Test Delete Results:");

		User user = new User();
		user.setName("Weslie");

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("age")
				.withIncludeNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

		Example<User> example = Example.of(user, matcher);
	}
}
