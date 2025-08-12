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
		
		Publication item1 = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		Publication item2 = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		Publication item3 = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		Publication item4 = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		Publication item5 = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");
		
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
		shoppingCart.addItem(item4);
		shoppingCart.addItem(item5);
		
		shoppingCart.displayCart();
		shoppingCart.printStatistics();
		shoppingCart.removeItem("빠삐용");
		shoppingCart.displayCart();
	}
	
	public ShoppingCart() {
		this.items = new ArrayList<Publication>();
	}
	public void addItem(Publication item) {
		items.add(item); System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}
	public boolean removeItem(String title) { 
	      for (int i = 0; i < items.size(); i++) { 
	    	  if (items.get(i).getTitle().equals(title)) { 
	    		  Publication removed = items.remove(i); 
	    		  System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다."); 
	    		  return true; // 성공적으로 제거됨 } 
	            }
	      }
	      System.out.println("해당 제목의 출판물을 찾을 수 없습니다."); 
	      return false; // 제거 실패 
	}
	
	public void displayCart() {
		System.out.println("=====장바구니 내용=====");
		
		if (items.isEmpty()) {
			System.out.println("장바구니가 비어 있습니다.");
			return;
		}

		for (int i = 0; i < items.size(); i++) {
			Publication item = items.get(i);
			System.out.printf("%d. %s - %s원%n", (i + 1), item.getTitle(), item.getPrice());
		}
		
		System.out.println("총 가격: " + calculateTotalPrice() + "원");
		System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
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
	         // ManageBook과는 다른 할인율 적용 (용도별 차별화) 
	        if (item instanceof Magazine) { 
	            total += item.getPrice() * 0.9; // 10% 할인 
	        } else if (item instanceof Novel) { 
	            total += item.getPrice() * 0.85; // 15% 할인 
	      } else if (item instanceof ReferenceBook) { 
	            total += item.getPrice() * 0.8; // 20% 할인 
	     } else { 
	            total += item.getPrice(); // 기본 출판물은 할인 없음 
	     } 
	} 
	  return total; 
	}

	public void printStatistics() {
		System.out.println("=====장바구니 통계=====");
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
	     System.out.println("잡지 :"+mgn+"권");
	        System.out.println("소설 :"+nov+"권");
	        System.out.println("참고서 :"+ref+"권");
	        System.out.println("총 출판물:"+items.size()+ "권");
	}
	
}
