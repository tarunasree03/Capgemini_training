package advance_java.day2.stream;

import java.util.List;
import java.util.Optional;

class Student2{
	int id;
	String name;
	int age;
	
	public Student2(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
public class All_implementation {
	
	public static void main(String[] args) {
		List <Student2> students = List.of(
				new Student2 (1, "Hari", 28),
				new Student2 (2, "Kumar", 17)
				);
				
		List<Student2> adults =students.stream()
				.filter(s -> s.getAge() > 18)
				.toList();
		
		System.out.println(adults);
		
		// for Each
		students.stream()
						.forEach(s -> System.out.println(s.getName()));
		
		// count
		long count =
				students.stream()
								.filter(s -> s.getAge() >18)
								.count();
		
		System.out.println(count);
		
		// findFirst()
		Optional <Student2> first =
				students.stream()
								.filter(s -> s.getAge() >18)
								.findFirst();
		
		// anyMatch()
		
		boolean anyMinor =
				students.stream()
								.anyMatch(s ->s.getAge() < 18);
		
		// allMatch()
		boolean allAdults = 
				students.stream()
								.allMatch(s -> s.getAge() > 18);
		
		// noneMatch
		boolean noneSenior =  
				students.stream()
								.noneMatch(s-> s.getAge() > 60);
		
		// reduce
		int totalAge = 
				students.stream()
								//.map(Student2::getAge) OR
								.map(s -> s.getAge())
								//.reduce(0, Integer::sum); // (a, b) -> a + b OR
								.reduce(0, (a, b) -> a + b);
		System.out.println(totalAge);
	}
}
