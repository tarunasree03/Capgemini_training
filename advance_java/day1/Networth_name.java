package advance_java.day1;
import java.util.ArrayList;
public class Networth_name {
	
	public static void main(String[] args) {
		
		Box <String> box = new Box();
		box.set("10");
		
		String s = box.get();
		
	}
	
}

class Box <T> {
	T value;
	
	void set (T value) {
		this.value = value;
	}
	
	T get() {
		return value;
	}
}

// T - Type, N - Number, K - Key, V - Value
// E - Element