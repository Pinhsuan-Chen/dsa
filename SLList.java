import java.io.*; 


// Java program to implement 
// a Singly Linked List 
public class SLList { 

	Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
	static class Node { 

		int data; 
		Node next; 

		// Constructor 
		Node(int d)
		{ 
			data = d; 
			next = null; 
		} 
	} 
	public void reverse(){
		head = reverseRecursiveHelper(head);

	}

	private Node reverseRecursiveHelper(Node front){
		if(front == null || front.next == null){
			return front;
		}else{
			Node reversed = reverseRecursiveHelper(front.next);
			front.next.next = front;
			front.next = null;
			return reversed;

		}
	}

	// Method to insert a new node 
	public static SLList insert(SLList list, int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		// If the Linked List is empty, 
		// then make the new node as head 
		if (list.head == null) { 
			list.head = new_node; 
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = list.head; 
			while (last.next != null) { 
				last = last.next; 
			} 

			// Insert the new_node at last node 
			last.next = new_node; 
		} 

		// Return the list by head 
		return list; 
	} 

	// Method to print the SLList. 
	public static void printList(SLList list) 
	{ 
		Node currNode = list.head; 

		System.out.print("SLList: "); 

		// Traverse through the SLList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " "); 

			// Go to next node 
			currNode = currNode.next; 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list. */
		SLList list = new SLList(); 

		// 
		// ******INSERTION****** 
		// 

		// Insert the values 
		list = insert(list, 1); 
		list = insert(list, 2); 
		list = insert(list, 3); 
		list = insert(list, 4); 
		// list = insert(list, 5); 
		// list = insert(list, 6); 
		// list = insert(list, 7); 
		// list = insert(list, 8); 

		// Print the SLList 
		printList(list); 
		list.reverse();
		printList(list); 
	} 
} 
