class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    // Function to merge two sorted linked lists
    private Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // Function to merge K sorted linked lists
    Node mergeKLists(Node[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        int last = arr.length - 1;
        while (last != 0) {
            int i = 0, j = last;

            while (i < j) {
                arr[i] = mergeTwoLists(arr[i], arr[j]);
                i++;
                j--;

                if (i >= j) last = j;
            }
        }
        return arr[0];
    }
}

public class MergeKsortedlinkedlists {
    // Function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example test
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(7);

        Node list2 = new Node(2);
        list2.next = new Node(8);
        list2.next.next = new Node(9);

        Node list3 = new Node(3);
        list3.next = new Node(6);

        Node[] arr = {list1, list2, list3};

        Solution sol = new Solution();
        Node result = sol.mergeKLists(arr);

        System.out.println("Merged List:");
        printList(result);
    }
}
