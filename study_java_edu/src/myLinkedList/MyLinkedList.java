package myLinkedList;

public class MyLinkedList {
	private Node head = null;
	
	private class Node {
		private String data;
		private Node link;
		
		public Node (String data) {
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
	
	public void print() {
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터: ");
			Node next = head;
			while (next != null) {
				System.out.println("data: " + next.data);
				next = next.link;
			}
		}
	}
	
	public void delete(String data) {
		if (head == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		} else {
			Node nNode = head;
			Node pNode = nNode;
			while (nNode != null) {
				String s;
				s = nNode.data;
				
				if (s.compareTo(data) == 0) {
					if (head == nNode) {
						head = nNode.link;
					} else {
					pNode.link = nNode.link;
					return;
					}
				} else {
					pNode = nNode;
					nNode = nNode.link;
				}
					
			}
			System.out.println("삭제할 데이터가 없습니다.");
		}
	}
}
