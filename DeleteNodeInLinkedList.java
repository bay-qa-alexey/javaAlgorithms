// 237. Delete Node in a Linked List (easy)
// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
// Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
// the linked list should become 1 -> 2 -> 4 after calling your function.


public class DeleteNodeInLinkedList {

    static public void main(String[] args) {
        ListNode element1 = new ListNode(1);
        ListNode element2 = new ListNode(2);
        ListNode element3 = new ListNode(3);
        ListNode element4 = new ListNode(4);
        element1.next=element2;
        element2.next=element3;
        element3.next=element4;

        for(ListNode tmpNode = element1; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }

        DeleteNodeInLinkedList deleteNodeInLinkedList = new DeleteNodeInLinkedList();
        deleteNodeInLinkedList.deleteNode(element3);

        System.out.println();
        for(ListNode tmpNode = element1; tmpNode != null; tmpNode = tmpNode.next){
            System.out.print(tmpNode.val);
        }

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }



}
