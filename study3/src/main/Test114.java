package main;

interface Itemp {
	public void print();
}

public class Test114 {

	public static void main(String[] args) {
		final int i = 100;
		
		Itemp t = new Itemp() {
			@Override
			public void print() {
				System.out.println("익명클래스 " + i);
			}
		};
		
		t.print();
	}
}
