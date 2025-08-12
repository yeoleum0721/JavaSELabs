package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;



public class ShoppingCart {
	private List<Publication> items;
	
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		Publication item1 = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
		Publication item2 = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
		Publication item3 = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
		Publication item4 = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
		Publication item5 = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");
		
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
		shoppingCart.addItem(item4);
		shoppingCart.addItem(item5);
		
		shoppingCart.displayCart();
		shoppingCart.printStatistics();
		shoppingCart.removeItem("���߿�");
		shoppingCart.displayCart();
	}
	
	public ShoppingCart() {
		this.items = new ArrayList<Publication>();
	}
	public void addItem(Publication item) {
		items.add(item); System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}
	public boolean removeItem(String title) { 
	      for (int i = 0; i < items.size(); i++) { 
	    	  if (items.get(i).getTitle().equals(title)) { 
	    		  Publication removed = items.remove(i); 
	    		  System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�."); 
	    		  return true; // ���������� ���ŵ� } 
	            }
	      }
	      System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�."); 
	      return false; // ���� ���� 
	}
	
	public void displayCart() {
		System.out.println("=====��ٱ��� ����=====");
		
		if (items.isEmpty()) {
			System.out.println("��ٱ��ϰ� ��� �ֽ��ϴ�.");
			return;
		}

		for (int i = 0; i < items.size(); i++) {
			Publication item = items.get(i);
			System.out.printf("%d. %s - %s��%n", (i + 1), item.getTitle(), item.getPrice());
		}
		
		System.out.println("�� ����: " + calculateTotalPrice() + "��");
		System.out.println("���� ���� ����: " + calculateDiscountedPrice() + "��");
	}
	
	public int calculateTotalPrice() {
		int total=0;
		for (Publication item : items) {
			total += item.getPrice();
		}
		return total;
		
	}
	public int calculateDiscountedPrice() { 
	     int total = 0; 
	     for (Publication item : items) { 
	         // ManageBook���� �ٸ� ������ ���� (�뵵�� ����ȭ) 
	        if (item instanceof Magazine) { 
	            total += item.getPrice() * 0.9; // 10% ���� 
	        } else if (item instanceof Novel) { 
	            total += item.getPrice() * 0.85; // 15% ���� 
	      } else if (item instanceof ReferenceBook) { 
	            total += item.getPrice() * 0.8; // 20% ���� 
	     } else { 
	            total += item.getPrice(); // �⺻ ���ǹ��� ���� ���� 
	     } 
	} 
	  return total; 
	}

	public void printStatistics() {
		System.out.println("=====��ٱ��� ���=====");
		int mgn=0;
		int nov=0;
		int ref=0;
		
	     for (Publication item : items) { 
	        if (item instanceof Magazine) { 
	            mgn++;
	        } else if (item instanceof Novel) { 
	            nov++; 
	        } 
	        else if (item instanceof ReferenceBook) {
	            ref++;     
	     } 
	}
	     System.out.println("���� :"+mgn+"��");
	        System.out.println("�Ҽ� :"+nov+"��");
	        System.out.println("���� :"+ref+"��");
	        System.out.println("�� ���ǹ�:"+items.size()+ "��");
	}
	
}
