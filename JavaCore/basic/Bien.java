package basic;

import java.util.List;

public class Bien {

	String nameString="Nga";
	static List<String> helloList;
	static String hello;
	
	static byte number=10;
	
	static int numberInt;
	static byte x=4;
	int a=23456;
	public void castingType() {
		byte y=x;
		y=5;
		System.out.println(x);
		System.out.println(y);
	}
	static int value=10;
	
	public static void main(String[] args) {
		Bien b=new Bien();
		
		//b.number=(byte) 5000;
//		System.out.println(b.number);
//		numberInt=number;
//		System.out.println(b.numberInt);
//		int i=10;
//		int y=i;
//		System.out.println(y);
//		System.out.println(i);
//		y=8;
//		System.out.println(y);
//		System.out.println(i);
//		System.out.println(b.value);
//		System.out.println(a.value);
//		b.value=8;
//		System.out.println(a.value);
//		System.out.println(b.value);
		b.castingType();
		
		Bien a= new Bien() {
			@Override
			public void castingType() {
				byte y=x;
				y=9;
				x=9;
				System.out.println(x);
				System.out.println(y);
				
			}
		};
		a.castingType();
		
		b =a;
		b.castingType();

	
		
		
	}

}
