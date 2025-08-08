package workshop.book.entity;

public class ReferenceBook extends Publication {
	private String field;
	public ReferenceBook() {
		// TODO Auto-generated constructor stub
	}

	public ReferenceBook(String title, String publishingDate, int page, int price,String field) {
		super(title, publishingDate, page, price);
		this.field = field;
	}
	public String getField() {
		return field;
	}
	private void setfield(String field) {
		this.field = field;

	}

}
