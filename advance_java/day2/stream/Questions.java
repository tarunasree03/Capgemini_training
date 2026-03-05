package advance_java.day2.stream;

import java.util.List;

class Student3{
	String name;
	int age;
	
	public Student3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

public class Questions {
	
	public static void main(String[] args) {
		
		List <Student3> students = List.of(
				new Student3 ("Ram", 20),
				new Student3 ("Hari", 17),
				new Student3("Sita", 25)
				);
		// 1 Get Names
		students.stream().forEach(s -> System.out.println("Names of students: "+s.getName()));
		
		//2 Count Adults
		long count = students.stream()
									.filter(s -> s.getAge() > 18)
									.count();
		System.out.println("No. of Adults: " +count);
		
		//3 Double Age
		List <Student3> doubleAge = students.stream()
											.filter(s -> s.getAge() >18 && s.getAge() < 40)
											.map(s -> new Student3(s.name,s.age* 2))
											.peek(s -> System.out.println(s.getAge()))
											.toList();
		
		// 4 Find Minor
		boolean anyMinor = students.stream()
											.anyMatch(s-> s.getAge() <18);
		
		// sum of  adult ages
		
	
		
		
		
	}		
}
