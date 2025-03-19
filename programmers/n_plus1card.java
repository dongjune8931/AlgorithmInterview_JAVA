package com.example.programmers;

import java.util.*;

class Solution {
	public int solution(int coin, int[] cards) {
		int n = cards.length;
		int cardSum = n + 1;
		Set<Integer> myCards = new HashSet<>();
		Set<Integer> pendingCards = new HashSet<>();
		int index = n / 3;

		for (int i = 0; i < index; i++) myCards.add(cards[i]);

		int round = 1;
		while (index < n) {
			pendingCards.add(cards[index]);
			pendingCards.add(cards[index + 1]);
			index += 2;

			if (isValidTwoCardMatch(myCards, cardSum)) {
				executeTwoCardMatch(myCards, cardSum);
			}
			else if (coin >= 1 && isValidOneCardMatchUsingExtra(myCards, pendingCards, cardSum)) {
				coin--;
				executeOneCardMatchUsingExtra(myCards, pendingCards, cardSum);
			}
			else if (coin >= 2 && isValidTwoCardMatch(pendingCards, cardSum)) {
				coin -= 2;
				executeTwoCardMatch(pendingCards, cardSum);
			}
			else {
				break;
			}

			round++;
		}
		return round;
	}

	private boolean isValidTwoCardMatch(Set<Integer> cards, int target) {
		for (int card : cards) {
			if (cards.contains(target - card) && card != target - card) {
				return true;
			}
		}
		return false;
	}

	private void executeTwoCardMatch(Set<Integer> cards, int target) {
		Iterator<Integer> it = cards.iterator();
		while (it.hasNext()) {
			int card = it.next();
			if (cards.contains(target - card) && card != target - card) {
				it.remove();
				cards.remove(target - card);
				return;
			}
		}
	}

	private boolean isValidOneCardMatchUsingExtra(Set<Integer> a, Set<Integer> b, int target) {
		for (int card : a) {
			if (b.contains(target - card)) {
				return true;
			}
		}
		return false;
	}

	private void executeOneCardMatchUsingExtra(Set<Integer> a, Set<Integer> b, int target) {
		Iterator<Integer> itA = a.iterator();
		while (itA.hasNext()) {
			int card = itA.next();
			if (b.contains(target - card)) {
				itA.remove();
				b.remove(target - card);
				return;
			}
		}
	}

	public class n_plus1card{
		public static void main(String[] args) {
			Solution solution=new Solution();
		}
	}
}
