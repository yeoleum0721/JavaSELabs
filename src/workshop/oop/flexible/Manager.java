package workshop.oop.flexible;
/* ������ Ŭ���� */
public class Manager extends Employee
{
	private String dept;
	
    public Manager (String name, double salary) 
    {
//        this.name = name;
//        this.salary = salary;
        super(name,salary);//�θ��� �����ڸ� �θ�
    }
    public Manager(String name, double salary,String dept)
    {
    	this(name,salary);
    	this.dept = dept;
    }
    public String getDept() {
    	return this.dept;
    }
    //overriding�� ��Ģ : �θ� ������� �޼���� signature�� �ݵ�� ���ƾ���  
    //@Override ������̼��� �������̵� ��Ģ�� ������ Ÿ�ӿ� üũ���ش�
    @Override
    public void manageSalary(double rate) 
    {
        salary = salary+ salary*(rate/100);
        salary += 20; // 20������ �߰��� �޴´�.
    }
}
