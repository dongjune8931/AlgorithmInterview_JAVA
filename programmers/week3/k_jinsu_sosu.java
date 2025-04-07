package com.example.programmers.week3;

class Solution2 {
	public int solution(int n, int k) {

		String converted = Integer.toString(n, k);

		String[] parts = converted.split("0");

		int count = 0;

		for (String part : parts) {
			if (part.isEmpty()) continue;

			long num = Long.parseLong(part);
			if (num < 2) continue;

			if (isPrime(num)) {
				count++;
			}
		}

		return count;
	}
	private boolean isPrime(long num) {
		if (num < 2) return false;
		for (long i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}

public class k_jinsu_sosu {
	public static void main(String[] args) {
		Solution2 solution2=new Solution2();
		System.out.println(solution2.solution(437674,3));
		System.out.println(solution2.solution(110011,10));
	}
}
