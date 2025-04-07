package com.example.programmers.week3;

import java.util.*;

class Solution3 {
	public int solution(int alp, int cop, int[][] problems) {
		int maxAlp = 0;
		int maxCop = 0;

		for (int[] p : problems) {
			maxAlp = Math.max(maxAlp, p[0]);
			maxCop = Math.max(maxCop, p[1]);
		}

		alp = Math.min(alp, maxAlp);
		cop = Math.min(cop, maxCop);

		int[][] dp = new int[maxAlp + 2][maxCop + 2];
		for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
		dp[alp][cop] = 0;

		for (int a = alp; a <= maxAlp; a++) {
			for (int c = cop; c <= maxCop; c++) {
				dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);

				dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);

				for (int[] p : problems) {
					if (a >= p[0] && c >= p[1]) {
						int na = Math.min(maxAlp, a + p[2]);
						int nc = Math.min(maxCop, c + p[3]);
						dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + p[4]);
					}
				}
			}
		}

		return dp[maxAlp][maxCop];
	}
}

public class CodingTestStudy {
	public static void main(String[] args) {

	}
}
