package com.example.programmers.week1;
import java.util.*;
import java.util.stream.*;

class Solution3 {
	private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
	private int maxPlusUsers = 0;
	private int maxSales = 0;

	public int[] solution1(int[][] users, int[] emoticons) {
		dfs(users, emoticons, 0, new int[emoticons.length]);
		return new int[]{maxPlusUsers, maxSales};
	}

	private void dfs(int[][] users, int[] emoticons, int depth, int[] discountSet) {
		if (depth == emoticons.length) {
			evaluate(users, emoticons, discountSet);
			return;
		}

		for (int discount : DISCOUNT_RATES) {
			discountSet[depth] = discount;
			dfs(users, emoticons, depth + 1, discountSet);
		}
	}

	private void evaluate(int[][] users, int[] emoticons, int[] discounts) {
		int[] result = Arrays.stream(users)
			.mapToInt(user -> {
				int userDiscount = user[0];
				int userLimit = user[1];

				int total = IntStream.range(0, emoticons.length)
					.filter(i -> discounts[i] >= userDiscount)
					.map(i -> emoticons[i] * (100 - discounts[i]) / 100)
					.sum();

				return total >= userLimit ? -1 : total; // -1이면 이모티콘 플러스 가입자
			})
			.toArray();

		int plusCount = (int) Arrays.stream(result).filter(v -> v == -1).count();
		int sales = Arrays.stream(result).filter(v -> v != -1).sum();

		if (plusCount > maxPlusUsers) {
			maxPlusUsers = plusCount;
			maxSales = sales;
		} else if (plusCount == maxPlusUsers) {
			maxSales = Math.max(maxSales, sales);
		}
	}

	public int[] solution2(int[][] users, int[] emoticons) {
		dfs(users, emoticons, 0, new int[emoticons.length]);
		return new int[]{maxPlusUsers, maxSales};
	}

	private void dfs2(int[][] users, int[] emoticons, int depth, int[] discountSet) {
		if (depth == emoticons.length) {
			evaluate(users, emoticons, discountSet);
			return;
		}

		for (int discount : DISCOUNT_RATES) {
			discountSet[depth] = discount;
			dfs(users, emoticons, depth + 1, discountSet);
		}
	}

	private void evaluate2(int[][] users, int[] emoticons, int[] discounts) {
		List<Integer> purchaseResults = Arrays.stream(users)
			.map(user -> calculatePurchase(user, emoticons, discounts))
			.collect(Collectors.toList());

		long plusCount = purchaseResults.stream().filter(price -> price == -1).count();
		int totalSales = purchaseResults.stream().filter(price -> price != -1).mapToInt(Integer::intValue).sum();

		if (plusCount > maxPlusUsers) {
			maxPlusUsers = (int) plusCount;
			maxSales = totalSales;
		} else if (plusCount == maxPlusUsers) {
			maxSales = Math.max(maxSales, totalSales);
		}
	}

	private int calculatePurchase(int[] user, int[] emoticons, int[] discounts) {
		int discountThreshold = user[0];
		int limit = user[1];

		int totalSpent = IntStream.range(0, emoticons.length)
			.filter(i -> discounts[i] >= discountThreshold)
			.map(i -> emoticons[i] * (100 - discounts[i]) / 100)
			.sum();

		return totalSpent >= limit ? -1 : totalSpent;
	}
}

public class emoticon_event {
	public static void main(String[] args) {

	}
}
