package workshop.oop.flexible;
/* ���� Ŭ���� */
public class MereClerk extends Employee {
    public MereClerk (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
    	super(name,salary);
    }
    
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}
