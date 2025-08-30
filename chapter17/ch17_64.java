package com.example.chapter17;

import java.util.LinkedList;

public class ch17_64 {

	public class ListNode{
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val){
			this.val=val;
		}
		ListNode(int val, ListNode next){this.val=val;
			this.next = next;}
	}

	public ListNode mergeTwoList(ListNode l1, ListNode l2){
		if(l1==null)return l2;
		if(l2==null)return l1;
		if(l1.val>l2.val){
			ListNode temp= l1;
			l1=l2;
			l2=temp;
		}
		l1.next=mergeTwoList(l1.next,l2);
		return l1;
	}
	public ListNode sortList(ListNode head){
		if(head==null||head.next==null)return head;
		ListNode half=null;
		ListNode slow=head;
		ListNode fast = head;
		while (fast != null || fast.next != null) {
			half=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		half.next=null;

		ListNode l1=sortList(head);
		ListNode l2=sortList(slow);

		return mergeTwoList(l1,l2);
	}
}
