package advance_java.day2.stream;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String [] args) {
		List <Integer> list = Arrays.asList(1,2,3,4,5,6);
		
//		List<E> <Integer> even = new ArrayList<>();
//		
//		for(Integer n : list) {
//			if(n % 2 == 0) {
//				even.add(n);
//			}
//		}
		
		List<Integer> even = list.stream() // source
				.filter(n -> n % 2 == 0) // intermediate
				.map(n -> n*2) // intermediate
				.toList(); // collect or terminal
		
		System.out.println(even);
		
		// Collection > Stream > Filter > Transform > Collect > Result
	}
}
