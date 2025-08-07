package mylab.library.entitiy;

import java.util.ArrayList;
import java.util.List;

import workshop.person.entity.PersonEntity;

public class Library {
	private  List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	public String getName() {
		return name;
	}
	public void addBook(Book book) {
		System.out.println("도서가 추가되었습니다 : " + book.getTitle());
		books.add(book);
	}
	public Book findBookByTitle(String title) {
		for(Book book:books) {
			if(book.getTitle().equals(title)) {
				return book;
			}
		}return null;
	}
	
	public List<Book> findBookByAuthor(String author){
		List<Book> authorBooks = new ArrayList<>();
		for(Book book:books) {
			if(book.getAuthor().equals(author)) {
				authorBooks.add(book);
			}
		}return authorBooks;
	}
	public Book findBookByISBN(String isbn) {
		for(Book book:books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}return null;
	}
	public boolean checkOutBook(String isbn) {
		for(Book book:books) {
			if(book.getIsbn().equals(isbn)) {
				if(book.isAvailable()) {
					book.checkOut();
					return true;
				}
				else {
					return false;
				}
			}
		}return false;
	}
	public boolean returnBook(String isbn) {
		for(Book book:books) {
			if(book.getIsbn().equals(isbn)) {
				if(!book.isAvailable()) {
					book.returnBook();
					return true;
				}
			}
		}return false;
	}
	public List<Book> getAvailabeBooks(){
		List<Book> availableBooks = new ArrayList<>();
		for(Book book:books) {
			if(book.isAvailable()) {
				availableBooks.add(book);
			}
		}return availableBooks;
	}
	public List<Book> getAllBooks(){
		List<Book> allBooks = new ArrayList<>();
		for(Book book:books) {
			allBooks.add(book);
		}
		return allBooks;
	}

	public int getTotalBooks() {
		return books.size();
	}
	public int getAvailableBooksCount() {
		int availBookCnt = 0;
		for (Book book:books) {
			if(book.isAvailable()) {
				availBookCnt++;
			}
		}
		return availBookCnt;
	}
	public int getBorrowedBooksCount() {
		int borrowBookCnt = 0;
		for (Book book:books) {
			if(!book.isAvailable()) {
				borrowBookCnt++;
			}
		}
		return borrowBookCnt;
	}
}
