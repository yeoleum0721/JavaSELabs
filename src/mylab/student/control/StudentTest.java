package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		Student student = new Student("2025118468", "��μ�", "��ǻ�Ͱ���", 3);
		
		System.out.println(student.getName()+'/'+student.getMajor()+'/'+student.getGrade()+"�г�");
		
		try {
			System.out.println("5�г����� ����");
			student.setGrade(5);
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
	}

}