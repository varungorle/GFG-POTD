"""
class Node:
    def __init__(self, val):
        self.data = val
        self.next = None
        self.prev = None
"""

class Node:
    def __init__(self, val):
        self.data = val
        self.next = None
        self.prev = None

class Solution:
    def reverse(self, head):
        if head is None:
            return None

        curr = head
        prev_node = None

        while curr:
            # swap prev and next
            curr.prev, curr.next = curr.next, curr.prev
            prev_node = curr
            curr = curr.prev  # move to next in original list

        return prev_node


# 🔹 Helper function to print DLL
def printDLL(head):
    res = []
    while head:
        res.append(str(head.data))
        head = head.next
    print(" <-> ".join(res))


# 🔹 Driver code
if __name__ == "__main__":
    # Create DLL: 1 <-> 2 <-> 3
    head = Node(1)
    node2 = Node(2)
    node3 = Node(3)

    head.next = node2
    node2.prev = head
    node2.next = node3
    node3.prev = node2

    print("Original DLL:")
    printDLL(head)

    sol = Solution()
    new_head = sol.reverse(head)

    print("Reversed DLL:")
    printDLL(new_head)
