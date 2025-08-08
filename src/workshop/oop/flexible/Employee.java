package workshop.oop.flexible;

public abstract class Employee {

	private String name;
	protected double salary;

	public Employee() {
	}
	

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	//Concrete Method
	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
	//Abstract Method
	public abstract void manageSalary(double rate);

}