package mylab.book.entity;

public class Novel extends Publication {
	private String author;
	private String genre;

	public Novel() {
	}

	public Novel(String title, String publishDate, int page, int price, String author, String genre) {
		super(title, publishDate, page, price);
		this.author = author;
		this.genre=genre;
	}
	//getters and setters

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return super.toString() + "소설 작가 : "+getAuthor()+", 소설 장르:" + getGenre() + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();

	}
}
