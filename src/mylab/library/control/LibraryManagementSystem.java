package mylab.library.control;

import java.util.List;

import mylab.library.entitiy.Book;
import mylab.library.entitiy.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		Library library = new Library("�߾ӵ�����");
		addSampleBooks(library);
		
		System.out.println("====="+library.getName()+"=====");
		libraryStatus(library);
		System.out.println();
		
		testFindBook(library);
		System.out.println();
		testCheckOut(library);
		System.out.println();
		
		System.out.println("������ ���� ���� : ");
		libraryStatus(library);
		
		testReturn(library);
		
		System.out.println("������ ���� ���� : ");
		libraryStatus(library);
		displayAvailableBooks(library);
	}
	public static void libraryStatus(Library library) {
		System.out.println("��ü ���� �� : "+ library.getTotalBooks());
		System.out.println("���� ���� ���� �� : " + library.getAvailableBooksCount());
		System.out.println("���� ���� ���� �� : " + library.getBorrowedBooksCount());
	}
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}

	private static void testFindBook(Library library) {
		System.out.println("=====���� �˻� �׽�Ʈ=====");
		System.out.println("�������� �˻� ���: ");
		String title = "�ڹ��� ����";
		Book bookTitle = library.findBookByTitle(title);
		String bookTitleInfo = bookTitle.toString();
		System.out.println(bookTitleInfo);
		System.out.println();
		
		System.out.println("�������� �˻� ��� :");
		String author = "Robert C. Martin";
		List<Book> bookAuthor = library.findBookByAuthor(author);
		String bookAuthorInfo = bookAuthor.toString();
		System.out.println(bookAuthorInfo);
	}
	private static void testCheckOut(Library library) {
		System.out.println("=====���� ���� �׽�Ʈ=====");
		String isbn = "978-89-01-14077-4";
		if(library.checkOutBook(isbn)){
			System.out.println("���� ���� ����!");
		}
		else {
			System.out.println("���� ���� �Ұ�!");
		}
		System.out.println("����� �������� : ");
		library.findBookByISBN(isbn).toString();
	}
	private static void testReturn(Library library) {
		System.out.println("=====���� �ݳ� �׽�Ʈ=====");
		String isbn = "978-89-01-14077-4";
		if(library.returnBook(isbn)){
			System.out.println("���� �ݳ� ����!");
		}
		else {
			System.out.println("���� �ݳ� �Ұ�!");
		}
		System.out.println("�ݳ��� �������� : ");
		library.findBookByISBN(isbn).toString();
	}
	private static void displayAvailableBooks(Library library){
		System.out.println("===== ���� ������ ���� ���=====");
		for(Book book:library.getAvailabeBooks()) {
			System.out.println(book.toString());
			System.out.println("----------------------------");
		}
	}
}
