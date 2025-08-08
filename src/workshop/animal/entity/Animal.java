package workshop.animal.entity;

public abstract class Animal {
	//변수
	protected int legs;

	//생성자
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	//메서드
	public abstract void eat();
	public void walk() {
		System.out.println("동물은" + this.legs + "개의 다리로 걷는다");
	}
}
