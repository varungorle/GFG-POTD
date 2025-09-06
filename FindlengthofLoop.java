public class FindlengthofLoop 
{

    static class Node
     {
        int data;
        Node next;

        Node(int x) 
        {
            data = x;
            next = null;
        }
    }

    static class Solution 
    {
        public int lengthOfLoop(Node head) 
        {
            if (head == null || head.next == null) return 0;

            Node slow = head, fast = head;

            while (fast != null && fast.next != null) 
            {
                slow = slow.next;       
                fast = fast.next.next;  

                if (slow == fast)
                { 
                    return countLoopLength(slow);
                }
            }

            return 0; 
        }

        private int countLoopLength(Node nodeInLoop) 
        {
            int count = 1;
            Node temp = nodeInLoop.next;
            while (temp != nodeInLoop) 
            {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }
    public static void main(String[] args) 
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

       
        head.next.next.next.next.next = head.next;

        Solution sol = new Solution();
        int loopLength = sol.lengthOfLoop(head);

        System.out.println("Length of Loop: " + loopLength);
    }
}

