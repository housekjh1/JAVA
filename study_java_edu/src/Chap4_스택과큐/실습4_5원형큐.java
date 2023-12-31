package Chap4_스택과큐;

/*
 * 원형 큐로서 큐에 Item 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 *   - 원형 큐를 어려워 한다 
 * 원형 큐 실습보다는 객체들의 큐를 ArrayList로 구현하는 실습이 더 유용
 */

import java.util.Scanner;

class Item {
	int data;

	public Item(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return " < " + this.data + " > ";
	}
}

public class 실습4_5원형큐 {

	static final int QUEUE_SIZE = 4;
	Item circleQueue[];
	int front, rear;
	static boolean isEmpty;

	public 실습4_5원형큐() {
		// 구현
		circleQueue = new Item[QUEUE_SIZE];
		front = rear = 0;
	}

	void push(int data) {
		// 구현
		if ((rear + 1) % QUEUE_SIZE == front) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		circleQueue[rear] = new Item(data);
		rear = (rear + 1) % QUEUE_SIZE;
	}

	Item pop() {
		// 구현
		if (front == rear) {
			System.out.println("큐가 비어 있습니다.");
			return null;
		}
		Item item = circleQueue[front];
		front = (front + 1) % QUEUE_SIZE;
		return item;
	}

	void clear() {
		// 구현
		front = rear = 0;
	}

	void print() {
		// 구현
		if (front == rear) {
            System.out.println("큐가 비어 있습니다.");
            return;
        }
        int current = front;
        while (current != rear) {
            System.out.print(circleQueue[current] + " ");
            current = (current + 1) % QUEUE_SIZE;
        }
        System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int pick;
		실습4_5원형큐 cq = new 실습4_5원형큐();
		while (true) {

			System.out.println("1. Push   2. Pop   3. Clear   4. Print");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			Item result = null;
			switch (pick) {
			case 1:
				cq.push((int) Math.round(Math.random() * 10));
				break;
			case 2:
				result = cq.pop();
				System.out.println("pop: result = " + result);
				break;
			case 3:
				cq.clear();
				break;
			case 4:
				cq.print();
				break;
			default:
				continue;
			}
		}

	}
}
