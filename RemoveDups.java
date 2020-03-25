import CtCILibrary.LinkedListNode;

import java.util.HashSet;


public class RemoveDups {

    public static void remDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();

        LinkedListNode prev = null;
        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
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
