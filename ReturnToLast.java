import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class ReturnToLast {

    public static int printList(LinkedListNode head, int k) {
        if (head == null) return 0;
        int index = printList(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(arr);
        for (int i = 0; i <= arr.length; i++) {
            printList(head, i);
        }
    }
}
