// 82. Remove Duplicates from Sorted List II (medium)
// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.


public class RemoveDuplicatesFromSortedList2 {

    static public void main(String[] args) {
        ListNode element1 = new ListNode(1);
        ListNode element2 = new ListNode(2);
        ListNode element3 = new ListNode(3);
        ListNode element4 = new ListNode(3);
        ListNode element5 = new ListNode(4);
        ListNode element6 = new ListNode(4);
        ListNode element7 = new ListNode(5);
        ListNode element8 = new ListNode(5);

        element1.next=element2;
        element2.next=element3;
        element3.next=element4;
        element4.next=element5;
        element5.next=element6;
        element6.next=element7;
        element7.next=element8;
        element8.next=null;

        for(ListNode tmpNode = element1; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }

        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        removeDuplicatesFromSortedList2.deleteDuplicates(element1);

        System.out.println();
        for(ListNode tmpNode = element1; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {return head;}
        if(head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            while(head.next != null && head.val == head.next.val) {
                    head = head.next;
            }
            return deleteDuplicates(head.next);
        }
    }

}
