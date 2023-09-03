package com.ruby.java.ch08.nonEnum;

import java.util.Scanner;

enum Mandarin1 {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);
	
	private int price;
	
	Mandarin1(int price) {
		this.price = price;
		System.out.println("enum 생성자 실행 / price: " + price);
	}
	
	public int getPrice() {
		return price;
	}
	
	static Mandarin1 MandarinAt(int idx) {
		for (Mandarin1 m : Mandarin1.values()) {
			if (m.ordinal() == idx) {
				return m;
			}
		}
		return null;
	}
}

public class EnumTestCopy01 {
	static Scanner stdIn = new Scanner(System.in);
	static Mandarin1 selectMenu() {
		int key;
		do {
		for (Mandarin1 m : Mandarin1.values()) {
			System.out.print(m.ordinal()+ ".");
			System.out.println(" " + m + "(" + m.getPrice()+ ")");
		}
		System.out.println("선택: ");
		key = stdIn.nextInt();
		} while(key < Mandarin1.금귤.ordinal() || key > Mandarin1.황금향.ordinal());
		
		return Mandarin1.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin1 choice = selectMenu();
		
		//System.out.println("enum 시작::");
		//Mandarin ma = Mandarin.한라봉;//enum 생성자가 호출되어 실행
		System.out.print("  순서: "+ choice.ordinal());
		System.out.println(" 이름: "+ choice.name() + ", 가격: " + choice.getPrice());

		/*
		System.out.println("황금향과 비교: "+ ma.compareTo(Mandarin.레드향));
		Mandarin m2	= Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m : list)
			System.out.println(m + ":" + m.getPrice());
			
			*/
	}
}