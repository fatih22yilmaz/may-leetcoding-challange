package com.cayro;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode evenCrawler = new ListNode();
        ListNode startOfEven = evenCrawler;
        ListNode oddCrawler = new ListNode();
        ListNode startOfOdd = oddCrawler;

        for (int i = 0; head != null; i++) {
            if (i % 2 == 0) {
                evenCrawler.next = head;
                evenCrawler = evenCrawler.next;
            } else {
                oddCrawler.next = head;
                oddCrawler = oddCrawler.next;
            }
            head = head.next;
        }
        evenCrawler.next = startOfOdd.next;
        oddCrawler.next = null;

        return startOfEven.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
