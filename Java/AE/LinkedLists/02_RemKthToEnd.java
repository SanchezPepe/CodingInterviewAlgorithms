import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		LinkedList p1 = head;
		LinkedList p2 = head;
		int count = 1;
		while(count < k){
			count++;
			p2 = p2.next;
		}
		LinkedList prev = head;
		while(p2.next != null){
			if(p1 != head) prev = prev.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		if(p1 == head){ 
			head.value = head.next.value;
			head.next = head.next.next;
			System.out.print(head.value);
		}
		else prev.next = p1.next;
		
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
