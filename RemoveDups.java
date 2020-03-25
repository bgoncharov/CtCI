import CtCILibrary.LinkedListNode;

import java.util.HashSet;


public class RemoveDups {

    public static void remDups(LinkedListNode list) {
        HashSet<Integer> set = new HashSet<Integer>();

        LinkedListNode prev = null;
        while (list != null) {
            if (set.contains(list.data)) {
                prev.next = list.next;
            } else {
                set.add(list.data);
                prev = list;
            }
            list = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        remDups(head);
        System.out.println(head.printForward());
    }
}
