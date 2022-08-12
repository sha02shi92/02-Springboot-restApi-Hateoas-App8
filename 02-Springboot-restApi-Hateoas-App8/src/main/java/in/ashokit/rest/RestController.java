package in.ashokit.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ashokit.binding.Book;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping(value="/book/{isbn}",produces= {"application/json"})
	public Book getBookInfo(@PathVariable("isbn") String isbn){
		
		Book b=new Book(isbn, "Spring", 300.00, "ROD JOHNSON");
		
		Link withRel=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RestController.class).getAllBooks())
		    .withRel("ALL-BOOKS");
		b.add(withRel);
		return b;
	}
	
	
	
	@GetMapping(value="/books",
			produces= {"application/json"})
	public List<Book> getAllBooks(){
		
		Book b1=new Book("ISBN001", "SPRING",300.00,"ROD JOHNSON");
		Book b2=new Book("ISBN002", "SPRING BOOT",400.00,"ROD JOHNSON");
		Book b3=new Book("ISBN003", "SPRING CLOUD",500.00,"ROD JOHNSON");
		
		List<Book> books=new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		return books;
	}
	

}
