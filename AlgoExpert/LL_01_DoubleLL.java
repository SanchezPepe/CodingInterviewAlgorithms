import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;
		
		// O(n) time | O(1) space
	public boolean containsNodeWithValue(int value) {
		Node node = head;
		
		while(node != null && node.value != value){
			node = node.next;
		}
      	return node != null;
    }
		
		// O(1) time | O(1) space
	  public void remove(Node node) {
			if(node == head) head = head.next;
			if(node == tail) tail = tail.prev;
			
			removeNodePointers(node);
    }
		
		public void removeNodePointers(Node node){
			if(node.prev != null) node.prev.next = node.next;
			if(node.next != null)	node.next.prev = node.prev;
			
			node.prev = null;
			node.next = null;
		}
		
		// O(n) time | O(1) space
    public void removeNodesWithValue(int value) {
			Node node = head;
			while(node != null){
				Node nodeToRemove = node;
				node = node.next;
				if(nodeToRemove.value == value) remove(nodeToRemove);
			}
    }
		
		// O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {
      // Write your code here.
			if(nodeToInsert == head && nodeToInsert == tail) return;
			
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			
			if(node.prev == null)	head = nodeToInsert;
			else node.prev.next = nodeToInsert;
			node.prev = nodeToInsert;
			
    }
		
		// O(1) time | O(1) space
    public void insertAfter(Node node, Node nodeToInsert) {
    	// Write your code here.
			if(nodeToInsert == head && nodeToInsert == tail) return;
			
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			
			if(node.next == null)	tail = nodeToInsert;
			else node.next.prev = nodeToInsert;
			node.next = nodeToInsert;
    }

		// O(1) time | O(1) space
    public void setHead(Node node) {
      // Write your code here.
			if(head == null){
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
    }

		// O(1) time | O(1) space
    public void setTail(Node node) {
      // Write your code here.
			if(tail == null){
				setHead(node);
				return;
			}
			insertAfter(tail, node);
    }

		// O(pos) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
			if(position == 1){
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPos = 1;
			
			while(node != null && currentPos != position){
				node = node.next;
				currentPos++;
			}
			
			if(node != null) insertBefore(node, nodeToInsert);
			else setTail(nodeToInsert);
    }

  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
