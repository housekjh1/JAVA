package Chap10_Tree;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습

class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}

	public TreeNode(int x) {
		LeftChild = RightChild = null;
		this.data = x;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	boolean hasOnlyLeft(TreeNode c) {
		if (c.LeftChild != null && c.RightChild == null) {
			return true;
		} else {
			return false;
		}
	}

	boolean hasOnlyRight(TreeNode c) {
		if (c.LeftChild == null && c.RightChild != null) {
			return true;
		} else {
			return false;
		}
	}

	boolean hasFull(TreeNode c) {
		if (c.LeftChild != null && c.RightChild != null) {
			return true;
		} else {
			return false;
		}
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode p = root, q = null;
		TreeNode tmp = new TreeNode(x);

		if (root == null) {
			root = tmp;
			System.out.println("초기값:" + x);
			return true;
		}
		while (p != null) {
			if (x < p.data) {
				q = p;
				p = p.LeftChild;
			} else if (x > p.data) {
				q = p;
				p = p.RightChild;
			} else {
				System.out.println("중복값 허용 안함 " + x);
				return false;
			}
		}
		if (x < q.data) {
			q.LeftChild = tmp;
		} else {
			q.RightChild = tmp;
		}
		return true;
	}

	boolean delete(int num) {
		TreeNode p = root, q = null;
		if (root == null) {
			System.out.println("트리가 비었습니다.");
			return false;
		}
		while (p != null) {
			if (num < p.data) {
				q = p;
				p = p.LeftChild;
			} else if (num > p.data) {
				q = p;
				p = p.RightChild;
			} else {
				break;
			}
		}

		if (p == null) {
			System.out.println("삭제할 데이터가 존재하지 않습니다.");
			return false;
		}

		if (isLeafNode(p)) {
			if (p == root) {
				root = null;
			} else if (p == q.LeftChild) {
				q.LeftChild = null;
			} else {
				q.RightChild = null;
			}
			p = null;
		} else if (hasOnlyLeft(p)) {
			if (p == root) {
				root = p.LeftChild;
			} else if (p == q.LeftChild) {
				q.LeftChild = p.LeftChild;
			} else {
				q.RightChild = p.LeftChild;
			}
			p = null;
		} else if (hasOnlyRight(p)) {
			if (p == root) {
				root = p.RightChild;
			} else if (p == q.LeftChild) {
				q.LeftChild = p.RightChild;
			} else {
				q.RightChild = p.RightChild;
			}
			p = null;
		} else if (hasFull(p)) {
			TreeNode tmp = inorderSucc(p);
			int tmpData = tmp.data;
			delete(tmpData);
			p.data = tmpData;
		}
		return true;
	}

	boolean search(int num) {
		TreeNode p = root, q = null;
		if (root == null) {
			System.out.println("트리가 비었습니다.");
			return false;
		}
		while (p != null) {
			if (num < p.data) {
				q = p;
				p = p.LeftChild;
			} else if (num > p.data) {
				q = p;
				p = p.RightChild;
			} else {
				return true;
			}
		}
		return false;
	}
}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (!t.insert(input[i]))
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num))
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.print("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
