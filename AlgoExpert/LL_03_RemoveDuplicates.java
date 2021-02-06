import java.util.*;

/*
	We need to travese the linked list with two pointers P1 and P2
	P1 points to the head, P2 to P1.next
	We move P2 until it's value is different from P1.
	After we find diferent values we set P1.next = P2 to remove duplicates and so on until we reach the end of the LL

	TC - O(n) - We traverse only one time the entire linked list and move the pointers to remove the duplicates
	SP - O(1) - No additional space was required, the removal was done in place
*/

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;
        LinkedList temp;

        while (current != null) {
            temp = current.next;
            while (temp != null && current.value == temp.value) {
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }

        return linkedList;
    }
}