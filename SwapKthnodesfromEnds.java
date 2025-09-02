public class SwapKthnodesfromEnds 
{
    static class Node 
    {
        int data;
        Node next;

        Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }

    public Node swapKth(Node head, int k)
    {
        if (head == null) return null;

        int length = 0;
        Node curr = head;
        while (curr != null) 
        {
            length++;
            curr = curr.next;
        }

        if (k > length) return head;           
        if (2 * k - 1 == length) return head;  

        Node firstPrev = null;
        Node first = head;
        for (int i = 1; i < k; i++) 
        {
            firstPrev = first;
            first = first.next;
        }

        Node secondPrev = null;
        Node second = head;
        for (int i = 1; i < length - k + 1; i++)
         {
            secondPrev = second;
            second = second.next;
        }

        if (firstPrev != null) firstPrev.next = second;
        if (secondPrev != null) secondPrev.next = first;

        Node temp = first.next;
        first.next = second.next;
        second.next = temp;

        if (k == 1) head = second;
        if (k == length) head = first;

        return head;
    }

    public void printList(Node head)
    {
        Node curr = head;
        while (curr != null) 
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SwapKthnodesfromEnds obj = new SwapKthnodesfromEnds();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        obj.printList(head);

        int k = 2;
        head = obj.swapKth(head, k);

        System.out.println("\nList after swapping " + k + "th node from start and end:");
        obj.printList(head);
    }
}
