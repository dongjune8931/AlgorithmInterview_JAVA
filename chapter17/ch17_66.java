package com.example.chapter17;

public class ch17_66 {
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

	public ListNode insertionSort(ListNode head){
		ListNode parent= new ListNode();
		ListNode p= parent;

		while(head!=null){
			while(p.next!=null&&p.next.val<head.val){
				p=p.next;
			}

			ListNode pNext=p.next;
			ListNode headNext=head.next;
			p.next=head;
			head.next=pNext;
			head=headNext;
			if(head!=null&&p.val>head.val){
				p=parent;
			}

		}
		return parent.next;
	}
}
