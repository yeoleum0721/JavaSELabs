package mylab.library.entitiy;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable=true;
	
	//constructor
	public Book() {}

	public Book(String title, String author, String isbn, int publishYear) {
		setTitle(title);
		setAuthor(author);
		setIsbn(isbn);
		setPublishYear(publishYear);
	}
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public boolean checkOut(){
		if(isAvailable) {
			return isAvailable = false;}
		else {
			return isAvailable = true;
			}
		}
	
	public void returnBook(){
		isAvailable = true;
	}
	public String toString(){
		String msg  = null;
		if (isAvailable) {
			msg = "����";
		}else {
			msg = "���� ��";
		}
		String bookInfo = String.format("å ���� : %s \t ���� : %s \t ISBN : %s ���ǳ⵵ : %d \t ���Ⱑ�ɿ��� :%s ", this.title, this.author,this.isbn,this.publishYear, msg);
		return bookInfo;
	}
}






