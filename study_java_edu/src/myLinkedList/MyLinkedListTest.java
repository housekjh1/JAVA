package myLinkedList;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		
		myList.print();
		myList.add("JAVA");
		myList.add("JS");
		myList.add("Python");
		myList.print();
		myList.delete("ABC");
		myList.delete("JAVA");
		myList.print();
		myList.add("JAVA");
		myList.print();
	}
}
