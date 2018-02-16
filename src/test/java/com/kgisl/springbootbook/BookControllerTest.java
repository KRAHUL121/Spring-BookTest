package com.kgisl.springbootbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private static final int Book_ID = 1;
	private static final Book EXISTING_Book = new BookBuilder().setId(1).setTitle("Title1").setAuthor("Author1").setPrice(100.99f).getbook();
	private static final Book ANOTHER_Book = new BookBuilder().setId(2).setTitle("Title2").getbook();
	private static final Book NEW_Book = new BookBuilder().setTitle("Title1").getbook();

	@InjectMocks
	private BookController bookController;
	@Mock
	private BookRepository bookRepository;

	@Test
	public void whenCreatingBookItShouldReturnTheSavedBook() {
		given(bookRepository.saveAndFlush(NEW_Book)).willReturn((EXISTING_Book));
		assertThat(bookController.addBook((NEW_Book))).isSameAs(EXISTING_Book);
	}

	@Test
	public void whenUpdatingBookItShouldReturnTheSavedBook() {
		given(bookRepository.getOne(Book_ID)).willReturn(EXISTING_Book);
		given(bookRepository.saveAndFlush(EXISTING_Book)).willReturn(EXISTING_Book);
		assertThat(bookController.updateBook(EXISTING_Book, Book_ID)).isSameAs(EXISTING_Book);
	}
	@Test
	public void whenReadingdingBookItShouldReturnIdBook() {
		given(bookRepository.findOne(Book_ID)).willReturn(EXISTING_Book);
		assertThat(bookController.findBook(Book_ID)).isSameAs(EXISTING_Book);
	}
	@Test
	public void whenReadingdingBookItShouldReturnAllBooks() {
		given(bookRepository.findAll()).willReturn(Arrays.asList(EXISTING_Book, ANOTHER_Book));
		assertThat(bookController.findBooks()).containsOnly(EXISTING_Book, ANOTHER_Book);
	}

	@Test
	public void whenDeletingABookItShouldUseTheRepository() {
		bookController.deleteBook(Book_ID);
		verify(bookRepository).delete(Book_ID);
	}

}