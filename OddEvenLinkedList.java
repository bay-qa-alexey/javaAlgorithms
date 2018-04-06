// 328. Odd Even Linked List (medium)
// Given a singly linked list, group all odd nodes together followed by the even nodes.
// Please note here we are talking about the node number and not the value in the nodes.
// You should try to do it in place.
// The program should run in O(1) space complexity and O(nodes) time complexity.
// Example:
// Given 1->2->3->4->5->NULL,
// return 1->3->5->2->4->NULL.
// Note:
// The relative order inside both the even and odd groups should remain as it was in the input.
// The first node is considered odd, the second node even and so on ...


public class OddEvenLinkedList {

    static public void main(String[] args) {

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

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
        element11.next = null;

        for(ListNode tmpNode = element1; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }

        ListNode pointer = oddEvenLinkedList.oddEvenList(element1);

        System.out.println();
        for(ListNode tmpNode = pointer; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }


    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode pointer = head;

        while(pointer != null) {

            if(pointer.val%2 == 0) {
                if(evenHead == null) {
                    evenHead = pointer;
                    evenTail = pointer;
                } else {
                    evenTail.next = pointer;
                    evenTail = pointer;
                }
            } else {
                if(oddHead == null) {
                    oddHead = pointer;
                    oddTail = pointer;
                } else {
                    oddTail.next = pointer;
                    oddTail = pointer;
                }
            }
            pointer=pointer.next;
        }
        evenTail.next = null;
        oddTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }

//    public ListNode oddEvenList2(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//        ListNode evenHead = head.next;
//        ListNode oddPointer = head;
//        ListNode evenPointer = head.next;
//        while(oddPointer.next != null && oddPointer.next.next != null) {
//            evenPointer = oddPointer.next;
//            oddPointer.next = oddPointer.next.next;
//            evenPointer.next = evenPointer.next.next;
//            oddPointer = oddPointer.next;
//        }
//        oddPointer.next = evenHead;
//        return head;
//    }


}