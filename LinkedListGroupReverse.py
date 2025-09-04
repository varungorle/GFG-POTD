class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    def reverseKGroup(self, head, k):
        if head is None or k <= 1:
            return head

        # Helper function to reverse k nodes
        def reverse_segment(start, k):
            prev, curr = None, start
            count = 0
            while curr and count < k:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
                count += 1
            return prev, curr   # (new_head, node_after_segment)

        dummy = Node(0)
        dummy.next = head
        prev_tail = dummy
        curr = head

        while curr:
            # Reverse next k nodes (even if < k remain, still reverse)
            new_head, next_node = reverse_segment(curr, k)

            prev_tail.next = new_head
            curr.next = next_node

            prev_tail = curr
            curr = next_node

        return dummy.next


# ---------------- DRIVER CODE ----------------

# Function to print linked list
def print_list(head):
    while head:
        print(head.data, end=" -> ")
        head = head.next
    print("None")


# Create linked list 1->2->3->4->5
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
head.next.next.next.next = Node(5)

print("Original list:")
print_list(head)

k = 2
solution = Solution()
new_head = solution.reverseKGroup(head, k)

print(f"Reversed in groups of {k}:")
print_list(new_head)
