package advance_java.day2.stream;
import java.util.Comparator;
import java.util.List;

public class StudentsWithSameMarksArranged {
	public static void main(String[] args) {
		List <Students> students = List.of(
				new Students ("A", 70, 21),
				new Students("B", 33, 45),
				new Students ("K", 88, 27),
				new Students ("Z", 98, 18)
				);
		
		List<Students> passed = students.stream()
				.sorted(Comparator
						.comparingInt((Students s) -> s.marks)
						.thenComparing(s -> s.name)
						)
				.toList();
		
		System.out.println(passed.size());
		
		
		for(Students s: passed) {
			System.out.println(s.name);
			//System.out.println(s.marks);
			//System.out.println(s.age);
		}
		
		
	}
}

class Students{
	String name;
	int marks;
	int age;
	
	public Students(String name, int marks, int age) {
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


