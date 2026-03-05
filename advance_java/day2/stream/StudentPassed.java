package advance_java.day2.stream;

import java.util.List;

public class StudentPassed {
	public static void main(String[] args) {
		List <Student> students = List.of(
				new Student ("A", 22, 21),
				new Student ("B", 33, 45),
				new Student ("K", 88, 27),
				new Student ("Z", 98, 18)
				);
		
		List<Student> passed = students.stream()
				.filter(n -> n.marks > 60 && n.age >= 18 && n.age < 40) // not transform or mutate
				.peek(s -> System.out.println("Passed: " + s.name))
				//.peek(s -> s.setMarks(s.marks *2)) // mutating OR 
				.peek(s -> s.marks = s.marks *2) // mutating
				.map(s -> new Student(s.name,s.marks*2, s.age)) // transform
				.peek(System.out::println)
				.toList();
		
		System.out.println(passed.size());
		
		
//		for(Student s: passed) {
//			System.out.println(s.name);
//			System.out.println(s.marks);
//			System.out.println(s.age);
//		}
		
		
	}
}

class Student{
	String name;
	int marks;
	int age;
	
	public Student(String name, int marks, int age) {
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