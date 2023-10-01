package Chap6_Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Chap6_Sorting.objectStack.EmptyGenericStackException;

//stack 1개를 사용한 non-recursve QuickSort() 구현
class objectStack{
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;
		public EmptyGenericStackException() {
			super();
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

    private List<Point> data;           // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public objectStack(int capacity) {
		//구현
		this.capacity = capacity;
		top = 0;
		try {
			data = new ArrayList<Point>(this.capacity);
		} catch (OutOfMemoryError e) {
			this.capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		//구현
		if (top >= capacity) throw new OverflowGenericStackException();
		data.add(top++, x);
		return true;
	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException  {
		//구현
		if (top <= 0) throw new EmptyGenericStackException();
		Point tmp = data.get(--top);
		data.remove(top);
		return tmp;
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException  {
		//구현
		if (top <= 0) throw new EmptyGenericStackException();
		return data.get(top - 1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		//구현
		if (top <= 0) {
			System.out.println("스택이 비었습니다.");
			return -1;
		}
		for (int i = 0; i < top; i++) {
			if (data.get(i) == x) return i;
		}
		return -1;
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		//구현
		if (top <= 0) {
			System.out.println("스택이 비었습니다.");
			return;
		}
		for (int i = 0; i < top; i++) {
			System.out.print(data.get(i) + " ");
		}
		System.out.println();
	}
}

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

public class Chap6_Test_QuickSort {

	//퀵 정렬(비재귀 버전)
	static int count;
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) throws EmptyGenericStackException {

		objectStack st = new objectStack(a.length);
		Point pt = new Point(left, right);
		st.push(pt);
		count = 0;
		while (!st.isEmpty()) {
			pt = st.pop();
			int pl = left = pt.getX();
			int pr = right = pt.getY();
			int x = a[(left + right)/2];
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr) {
					swap(a, pl++, pr--);
					count++;
				}
			} while (pl <= pr);
			
			if (left < pr) {
				st.push(new Point(left, pr));
			}
			if (pl < right) {
				st.push(new Point(pl, right));
			}
		}

	}

	public static void main(String[] args) throws EmptyGenericStackException {
		Random rd = new Random();
		int nx = 1000;
		int[] x = new int[nx];
		for (int ix = 0; ix < nx; ix++) {
			int d = rd.nextInt(20) + 1;
			x[ix] = d;
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println("\n" + count);
	}
}
