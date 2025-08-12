package mylab.book.entity;

public class Magazine extends Publication {
	private String publishPeriod;
	public Magazine() {
	}

	public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod=publishPeriod;
	}
	//getters and setters
	public String getPublishPeriod() {
		return publishPeriod;
	}

	public void setPublishPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}
	@Override
	public String toString() {
		return super.toString() + " ���� �����ֱ�:" + publishPeriod + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
	}
}

