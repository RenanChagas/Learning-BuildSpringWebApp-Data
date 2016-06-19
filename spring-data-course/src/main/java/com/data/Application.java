package com.data;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);
		
		//Sort
		for(Book b: repository.findAll(new Sort(Sort.Direction.ASC,"author.lastName"))){
			System.out.print(b);
		}
		
		for(Book b: repository.findByPageCountGreaterThan(150, new PageRequest(0,5))){
			System.out.println(b);
		}
		
		for(Book b: repository.findAll(new PageRequest(0,5))){
			System.out.println(b);
		}
		
		for(Book b: repository.queryThree("Lord of the Flies")){
			System.out.println(b);
		}
		
		for(Book b: repository.queryOne()){
			System.out.println(b);
		}
		/*
		@SuppressWarnings("serial")
		List<Book> books = repository.findAll(new ArrayList<Long>(){{
			add(1L);
			add(3L);
			add(7L);
		}});

		for(Book book:books){
			System.out.println(book);
		}
		
		for(Book book2: repository.findByTitleLike("%of%")){
			System.out.println(book2);
		}
		
		Date date = new SimpleDateFormat("MM/dd/yyyy").parse("10/22/1995");
		for(Book book3: repository.findByPublishDateAfter(date)){
			System.out.println(book3);
		}
		
		for(Book book4:repository.findByTitleContainingOrderByTitleAsc("a")){
			System.out.println(book4);
		}
		
		for(Book book5:repository.findByAuthor_Country("England")){
			System.out.println(book5);
		}
		
		System.out.println(repository.findByTitle("The Grapes of Wrath"));
		*/
	}
}