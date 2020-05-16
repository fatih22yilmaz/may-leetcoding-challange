package com.cayro;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        ListNode fifth = new ListNode(5, null);
//        ListNode fourth = new ListNode(4, fifth);
//        ListNode third = new ListNode(3, fourth);
//        ListNode second = new ListNode(2, third);
//        ListNode head = new ListNode(1, second);

        ListNode seventh = new ListNode(7, null);
        ListNode sixth = new ListNode(4, seventh);
        ListNode fifth = new ListNode(6, sixth);
        ListNode fourth = new ListNode(5, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(1, third);
        ListNode head = new ListNode(2, second);

        ListNode listNode = solution.oddEvenList(head);
        int val = listNode.val;
    }

}
