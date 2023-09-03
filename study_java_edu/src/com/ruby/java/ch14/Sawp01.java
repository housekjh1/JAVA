package com.ruby.java.ch14;

import java.util.Scanner;

@FunctionalInterface
interface NumFunc {
	public int func(int a, int b);
}

public class Sawp01 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			NumFunc nf = (a, b) -> {
				int result = 0;
				for (int i = a; i <= b; i++) {
					result += i;
				}
				return result;
			};
			int n, m;

			while (true) {
				System.out.print("수를 입력하세요.: ");
				if ((n = sc.nextInt()) == 0)
					break;
				System.out.print("수를 입력하세요.: ");
				if ((m = sc.nextInt()) == 0)
					break;

				if (n > m) {
					int t = m;
					m = n;
					n = t;
				}
				System.out.println(n + "부터 " + m + "까지의 합 : " + nf.func(n, m));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
