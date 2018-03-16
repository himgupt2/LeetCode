/*
 Author: Himanshu Gupta, himgupt2@gmail.com
----

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode itr = head;
        
        while(l1!=null && l2!=null){
            
            int s = l1.val + l2.val + carry;
            
            
            ListNode sum = new ListNode(s%10);
            itr.next = sum;
            itr = itr.next;
            
            
            carry = s > 9 ? 1:0;
            if(l1.next!=null && l2.next!=null) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                break;
            }
            
        }
        
        if (l1.next == null && l2.next == null && carry==1){
            ListNode sum = new ListNode(1);
            itr.next = sum;
            itr=itr.next;
            carry = 0;
        }
        
        if(l1.next==null){
            while(l2.next!=null){
                l2 = l2.next;
                int s = l2.val + carry;
                ListNode sum = new ListNode(s%10);
                carry = s > 9 ? 1:0;
                itr.next = sum;
                itr=itr.next;
            }
        }
        
        if(l2.next==null){
            while(l1.next!=null){
                l1 = l1.next;
                int s = l1.val + carry;
                ListNode sum = new ListNode(s%10);
                carry = s > 9 ? 1:0;
                itr.next = sum;
                itr=itr.next;
            }
        }
        
        if(carry==1){
            ListNode sum = new ListNode(1);
            itr.next = sum;
            itr=itr.next;
        }
        
        return head.next;
    }
}

