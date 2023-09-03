package com.ruby.java.ch08.nonEnum;

import java.util.Scanner;

//자료구조시에 사용
enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);

	private int price;
	//enum의 생성자: enum 상수마다 생성자를 호출하여 초기화한다.
	Mandarin(int p) {
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}

	int getPrice() {
		return price;
	}
	
	static Mandarin MandarinAt(int idx) {
		for (Mandarin m : Mandarin.values())
			if (m.ordinal() == idx)
				return m;
		return null;
	}
}



public class EnumTest02 {
	static Scanner stdIn = new Scanner(System.in);
	static Mandarin selectMenu() {
		int key;
		do {
		for (Mandarin m : Mandarin.values()) {
			System.out.print(m.ordinal()+ ".");
			System.out.println(" " + m + "(" + m.getPrice()+ ")");
		}
		System.out.println("선택: ");
		key = stdIn.nextInt();
		} while(key < Mandarin.금귤.ordinal() || key > Mandarin.황금향.ordinal());
		
		return Mandarin.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin choice = selectMenu();
		
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