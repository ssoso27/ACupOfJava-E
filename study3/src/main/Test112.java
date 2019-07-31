package main;

public class Test112 {
	public static void test(Object... args){
		for (int i = 0; i < args.length; i++) {
			if ( args[i] == null ) {
				System.out.println("null");
			} else if ( args[i] instanceof Integer ) {
				int r = ( (Integer)args[i] ).intValue();
				System.out.println("integer : " + r);
			} else if ( args[i] instanceof Double ) {
				double r = ( (Double)args[i] ).doubleValue();
				System.out.println("double : " + r);
			} else if ( args[i] instanceof String ) {
				System.out.println("string : " + (String)args[i] );
			}
		}
	}
	
	public static void main(String[] args) {
		test("apple", 1, 3.3);
		test();
		test("¾å", "ªy");
		test(100, 2.01, 0.3); // int -> Integer (AutoBoxing)
		
	}
}
