package Chap5_Recursive;

class Point {
	private int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

class Stack {
	private Point[] data;
	private int capacity, pt;

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public Stack(int maxlen) {
		this.capacity = maxlen;
		this.pt = 0;
		try {
			this.data = new Point[capacity];
		} catch (Exception e) {
			this.capacity = 0;
		}
	}

	public void push(Point p) throws OverflowIntStackException {
		if (pt >= capacity)
			throw new OverflowIntStackException();
		data[pt++] = p;
		return;
	}

	public Point pop() throws EmptyIntStackException {
		if (pt <= 0)
			throw new EmptyIntStackException();
		return data[--pt];
	}

	public Point peek() throws EmptyIntStackException {
		if (pt <= 0)
			throw new EmptyIntStackException();
		return data[pt - 1];
	}

	public void clear() {
		pt = 0;
	}

	public int indexOf(Point p) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(p))
				return i;
		}
		return -1;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return pt;
	}

	public boolean isEmpty() {
		return pt <= 0;
	}

	public boolean isFull() {
		return pt >= capacity;
	}

	public void dump() {
		if (pt <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < pt; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	}
}

public class Chap5_Test_QueenEight_4회차_01 {

	public static boolean checkRow(int[][] d, int x) {
		for (int i = 0; i < d[0].length; i++) {
			if (d[x][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int y) {
		for (int i = 0; i < d.length; i++) {
			if (d[i][y] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkSE(int[][] d, int x, int y) {
		for (int ix = x, iy = y; ix < d.length && iy < d[0].length; ix++, iy++) {
			if (d[ix][iy] == 1)
				return false;
		}
		for (int ix = x, iy = y; ix >= 0 && iy >= 0; ix--, iy--) {
			if (d[ix][iy] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkSW(int[][] d, int x, int y) {
		for (int ix = x, iy = y; ix < d.length && iy >= 0; ix++, iy--) {
			if (d[ix][iy] == 1)
				return false;
		}
		for (int ix = x, iy = y; ix >= 0 && iy < d[0].length; ix--, iy++) {
			if (d[ix][iy] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkMove(int[][] d, int x, int y) {
		return checkRow(d, x) && checkCol(d, y) && checkSE(d, x, y) && checkSW(d, x, y);
	}

	public static int nextMove(int[][] d, int x, int y) {
		for (int i = y; i < d[0].length; i++) {
			if (checkMove(d, x, i)) {
				return i;
			}
		}
		return -1;
	}

	public static void solveQueen(int[][] d) {
		int count = 0, n = 8, q = 1;
		int x = 0, y = 0;
		Stack s = new Stack(n);
		Point p = new Point(x, y);

		while (true) {
			while (count < n) {
				if (x == 0 && y >= d[0].length && s.isEmpty())
					break;
				y = nextMove(d, x, y);
				if (y != -1) {
					d[x][y] = 1;
					count++;
					s.push(new Point(x, y));
					x++;
					y = 0;
				} else {
					if (!s.isEmpty()) {
						p = s.pop();
						x = p.getX();
						y = p.getY();
						d[x][y] = 0;
						count--;
						y++;
					} else {
						break;
					}
				}
			}
			if (x == 0 && y >= d[0].length && s.isEmpty()) {
				System.out.println("모든 풀이가 완료되었습니다.");
				break;
			}
			System.out.println("풀이 " + q++);
			printQueen(d);
			p = s.pop();
			x = p.getX();
			y = p.getY();
			d[x][y] = 0;
			count--;
			y++;
		}
	}

	private static void printQueen(int[][] data) {
		for (int[] element : data) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(element[j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		solveQueen(data);
	}
}
