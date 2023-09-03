package com.ruby.java.ch08.innerClass;

public class cha08_test_내부클리스구현 {
	private Node head;
	public cha08_test_내부클리스구현() {
		head = null;
	}
	private class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.data = data;
		}
	}
	public void add(String data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}
	public void printList() {
		//printList() 결과는 A -> B -> C 등으로 출력한다
		if (head == null) {
			System.out.println("입력값이 없습니다.");
		} else {
			System.out.println("==========" + "\n입력값: \n" + "==========");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	public void delete(String data) {
		if (head == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		} else {
			Node p = head;
			Node q = p;
			
			while (p != null) {
				String s = p.data;
				
				if (s.compareTo(data) == 0) {
					if (head == p) {
						head = p.link;
					} else {
						System.out.println("==========" + "\n" + '"' + data + '"' + " 삭제\n" + "==========");
						q.link = p.link;
						return;
					}
				} else {
					q = p;
					p = p.link;
				}
			}
			System.out.println("==========" + "\n삭제할 데이터가 없습니다.\n" + "==========");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cha08_test_내부클리스구현 myList = new cha08_test_내부클리스구현();
		myList.printList();

		myList.add("JAVA");
		myList.add("HTML");
		myList.add("CSS");
		myList.add("Javascript");
		myList.printList();
		myList.delete("JAVA");
		myList.printList();
	}
}
