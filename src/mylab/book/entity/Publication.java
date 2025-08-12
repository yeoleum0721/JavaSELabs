package mylab.book.entity;

public class Publication {
	private String title;
	private String publishDate;
	private int page;
	private int price;
	
	//constructor
	public Publication() {
	}

	public Publication(String title, String publishDate, int page, int price) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.page = page;
		this.price = price;
	}
	
	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "���ǹ� ���� : "+ getTitle();
	}
		
}
