package advance_java.day2.stream;

import java.util.List;

public class StudentStartsWithA {
	public static void main(String[] args) {
		List <Student1> students = List.of(
				new Student1 ("A", 70, 21),
				new Student1("B", 33, 45),
				new Student1 ("AK", 88, 27),
				new Student1 ("Z", 98, 18)
				);
		
		List<Student1> passed = students.stream()
				.filter(s -> s.marks > 60) // not transform or mutate
				.filter(s -> s.name.startsWith("A"))
				.toList();
		
		System.out.println(passed.size());
		
		
//		for(Student s: passed) {
//			System.out.println(s.name);
//			System.out.println(s.marks);
//			System.out.println(s.age);
//		}
		
		
	}
}

class Student1{
	String name;
	int marks;
	int age;
	
	public Student1(String name, int marks, int age) {
		this.name = name;
		this.marks = marks;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
