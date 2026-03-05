package advance_java.day1;

public class Main {
	public static void main(String[] args) {
		// Implementation using overriding
//		Demo demo = new DemoImpl();
//		demo.sample();
		
		// If the method is not an argument method and not a return type method in the Functional Interface
		/*
		Demo demo =()->{
			System.out.println("Method Impled By Using Lamda Expression");
		};
		demo.sample();
		
		// Without '{}'
		Demo demo1 =()->
			System.out.println("Method Impled By Using Lamda Expression");
		demo1.sample();
		
		*/
		
		// If the method is an argument method and not a return type method in the Functional Interface
//		Demo demo = (num)->{
//			System.out.println("For Argument Method");
//		};
//		
//		demo.sample(10000);
		
		// If the method is single argument method and single statement is provided for the method
		
//		Demo demo = num -> System.out.println("For Argument Method");
//		demo.sample(10);
//		
//		Demo1 demo1 = (num1, num2)->{
//			System.out.println("For 2 Argument Method");
//		};
//		
//		demo1.sample1(44, 55);
		
		
//		Demo1 demo1 =(num1 + num2)->{
//			return num1 + num2;
//	};
//		
//		System.out.println(demo1.sample1(100, 200));
		
		
		Demo1 demo2 = (num1, num2) -> num1+num2;
		System.out.println(demo2.sample1(1000, 20));
		
	}
}
