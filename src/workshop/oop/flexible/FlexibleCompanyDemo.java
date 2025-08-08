package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager manager = new Manager("ȫ�浿", 200);
        
        //�ڽ� mgr = new �ڽ� vs �θ� mgr = new �ڽ�
        Manager hrMgr = new Manager("�Ѹ�",200,"HR");
        System.out.println(hrMgr.getName());
        System.out.println(hrMgr.getSalary());
        System.out.println(hrMgr.getDept());
        
        //Polymorphism(������)
        //������ �θ�� �ڽĸ� ������ �ִ� �޼��带 ����
        Employee itMgr = new Manager("�浿",200,"IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        //�ڽ�(Manager)�� ���� getDept()�޼��� ȣ���ϱ� -> casting
        Manager itMgr2 = (Manager)itMgr;
        System.out.println(itMgr2.getDept());
        //((Manager)itMgr).getDept();
        
        //Heterogeneous Collection Employee Ÿ���� �迭 ����
        Employee[] emps = new Employee[4];
        emps[0] = new Manager("�浿",200,"IT");
        emps[1] = new MereClerk("ö��", 100);
        emps[2] = new MereClerk("����", 100);
        emps[3] = new Manager("�Ѹ�",200,"HR");
        
        System.out.println("���� �����Դϴ�.");
        printEmployeeInfo(emps);
        
        for (Employee emp:emps) {
        	emp.manageSalary(10);
        }
        
        System.out.println("�ø� ���� �����Դϴ�.");
        printEmployeeInfo(emps);
   }

	public static void printEmployeeInfo(Employee[] emps) {
		for (Employee emp:emps) {
			if(emp instanceof Manager) {
				System.out.print("������ �μ��� = "+((Manager)emp).getDept()+ " ");
			}
			System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");
        }
	}
}

