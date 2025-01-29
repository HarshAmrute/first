//https://leetcode.com/problems/add-two-numbers/description/
//My orignal solution without knowledge of Backtracking
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution 
// {
//     // public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
//     // {
//     //     ListNode s = new ListNode();
//     //     ListNode t = new ListNode();
//     //     long n1 = 0,n2 = 0;

//     //     t = l1;
//     //     int p = 0;
//     //     while(t != null)
//     //     {
//     //         n1 = (long)((t.val)*Math.pow(10,p)) + n1;

//     //         t = t.next;
//     //         p++; 
//     //     }
//     //     t = l2;
//     //     p = 0;
//     //     while(t != null)
//     //     {
//     //         n2 = (long)((t.val)*Math.pow(10,p)) + n2;

//     //         t = t.next;
//     //         p++; 
//     //     }
//     //     long n3 = n1 + n2;

//     //     System.out.println(n3);

//     //     if (n3 == 0) 
//     //     {
//     //         return new ListNode(0);
//     //     }

//     //     t = null;
//     //     s = null; // Initialize `s` to null
//     //     long x = n3;

//     //     while (x > 0) 
//     //     {
//     //         ListNode h = new ListNode();
//     //         int r = (int) (x % 10); // Extract the last digit
//     //         x = x / 10; // Remove the last digit from x
//     //         h.val = r;
//     //         h.next = null;

//     //         if (s == null) 
//     //         {// Initialize the head of the result list
//     //             s = h;
//     //             t = h;
//     //         } 
//     //         else 
//     //         {// Add the new node to the end of the list
//     //             t.next = h;
//     //             t = t.next;
//     //         }
//     //     }

//     //     return s;

//     //}

// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{   
    public class ListNode 
    {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }








    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s = null; // Result linked list head
        ListNode t = null; // Pointer for traversal
        int carry = 0; // Carry for digit addition

        // Process until both lists are null and carry is 0
        while (l1 != null || l2 != null || carry > 0) {
            // Call a helper method to calculate sum and carry
            int[] result = calculateSumAndCarry(l1, l2, carry);
            int digit = result[0]; // Extract the digit
            carry = result[1]; // Extract the carry

            // Call a helper method to append the digit to the result list
            s = appendToResult(s, digit);

            // Advance input lists
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            // Move the pointer `t` in the result list
            if (t == null)
                t = s;
            else
                t = t.next;
        }

        return s; // Return the head of the result list
    }

    // Helper method to calculate sum and carry
    private int[] calculateSumAndCarry(ListNode l1, ListNode l2, int carry) {
        int n1 = (l1 != null) ? l1.val : 0; // Value from l1, or 0 if null
        int n2 = (l2 != null) ? l2.val : 0; // Value from l2, or 0 if null
        int sum = n1 + n2 + carry; // Compute sum
        return new int[] { sum % 10, sum / 10 }; // Return digit and carry
    }

    // Helper method to append a digit to the result linked list
    private ListNode appendToResult(ListNode s, int digit) {
        ListNode h = new ListNode(digit); // Create a new node for the digit

        if (s == null) {
            return h; // If the list is empty, return the new node as the head
        } else {
            ListNode t = s; // Traverse to the end of the list
            while (t.next != null) {
                t = t.next;
            }
            t.next = h; // Append the new node at the end
        }
        return s; // Return the updated list
    }
}

