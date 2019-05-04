/**
* Bubble Sort
*/

public class Sorting {
	public static void main(String[] args) {
		Node head = null;
		
		//To create a linked list with 20 elements
		for (int i = 0; i < 20; i++) {
			head = add(head, (int) (Math.random() * 100));
		}
		System.out.println("Traversing the list before sorting:");
		traverse(head);
		System.out.println("Traversing the list after sorting:");
		head = sorting(head);
		traverse(head);
	}

	private static Node sorting(Node head) {
		Node temp = head;
		int t;
		Node temp2 = null;
		while (temp != null) {
			temp2 = temp.next;
			while (temp2 != null) {
				if (temp.val > temp2.val) {
					t = temp.val;
					temp.val = temp2.val;
					temp2.val = t;
				}
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		return head;
	}

	private static void traverse(Node head) {
		if (head == null)
			return;
		else {
			System.out.println(head.val);
			head = head.next;
			traverse(head);
		}
	}

	private static Node add(Node head, int i) {
		Node node = new Node();
		node.setVal(i);
		if (head != null) {
			node.next = head;
		}
		return node;
	}

}

class Node {

	Node next;
	int val;

	public Node(int val2, Node next2) {
		val = val2;
		next = next2;
	}

	public Node() {
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setVal(int val) {
		this.val = val;
	}

}