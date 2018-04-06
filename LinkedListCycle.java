//141. Linked List Cycle (easy)
//Given a linked list, determine if it has a cycle in it.
// Follow up:
// Can you solve it without using extra space?


import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    static public void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        ListNode element1 = new ListNode(1);
        ListNode element2 = new ListNode(2);
        ListNode element3 = new ListNode(3);
        ListNode element4 = new ListNode(4);
        ListNode element5 = new ListNode(5);
        ListNode element6 = new ListNode(6);
        ListNode element7 = new ListNode(7);
        ListNode element8 = new ListNode(8);
        ListNode element9 = new ListNode(9);
        ListNode element10 = new ListNode(9);
        ListNode element11 = new ListNode(8);

        element1.next = element2;
        element2.next = element3;
        element3.next = element4;
        element4.next = element5;
        element5.next = element6;
        element6.next = element7;
        element7.next = element8;
        element8.next = element9;
        element9.next = element10;
        element10.next = element11;
        element11.next = element5;

        System.out.println(linkedListCycle.hasCycle(element1));
    }

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode hare = head;
        ListNode turtoise = head;
        while(hare!= null && hare.next != null){
            hare = hare.next.next;
            turtoise = turtoise.next;
            if(hare == turtoise){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> mySet = new HashSet<>();
        ListNode pointer = head;
        while(pointer != null) {
            if (mySet.contains(pointer)) {
                return true;
            } else {
                mySet.add(pointer);
            }
            pointer = pointer.next;
        }
        return false;
    }

}
