package workshop.oop.flexible;
/* 관리자 클래스 */
public class Manager extends Employee
{
	private String dept;
	
    public Manager (String name, double salary) 
    {
//        this.name = name;
//        this.salary = salary;
        super(name,salary);//부모의 생성자를 부름
    }
    public Manager(String name, double salary,String dept)
    {
    	this(name,salary);
    	this.dept = dept;
    }
    public String getDept() {
    	return this.dept;
    }
    //overriding의 규칙 : 부모가 상속해준 메서드와 signature가 반드시 같아야함  
    //@Override 어노테이션은 오버라이딩 규칙을 컴파일 타임에 체크해준다
    @Override
    public void manageSalary(double rate) 
    {
        salary = salary+ salary*(rate/100);
        salary += 20; // 20만원을 추가로 받는다.
    }
}
