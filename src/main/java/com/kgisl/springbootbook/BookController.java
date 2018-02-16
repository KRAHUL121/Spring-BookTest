package com.kgisl.springbootbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  private BookRepository bookRepository;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Book> findBooks() {
    return bookRepository.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Book findBook(@PathVariable Integer id) {
    return  bookRepository.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Book addBook(@RequestBody Book item) {
    item.setId(0);
    return bookRepository.saveAndFlush(item);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public Book updateBook(@RequestBody Book updatedItem, @PathVariable Integer id) {
    updatedItem.setId(id);
    return bookRepository.saveAndFlush(updatedItem);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteBook(@PathVariable Integer id) {
    bookRepository.delete(id);
  }
}