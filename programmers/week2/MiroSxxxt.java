package com.example.programmers.week2;
class Solution2 {
	static int[] dx = {1, 0, 0, -1}; // d, l, r, u
	static int[] dy = {0, -1, 1, 0};
	static char[] dir = {'d', 'l', 'r', 'u'};
	static String answer = "impossible";
	static boolean found = false;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		int dist = Math.abs(r - x) + Math.abs(c - y);
		if (dist > k || (k - dist) % 2 != 0) {
			return "impossible";
		}

		dfs(x, y, "", k, n, m, r, c);
		return answer;
	}

	private void dfs(int x, int y, String path, int remaining, int n, int m, int r, int c) {
		if (found) return;

		if (remaining == 0) {
			if (x == r && y == c) {
				answer = path;
				found = true;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

			int currentDist = Math.abs(r - nx) + Math.abs(c - ny);
			if (currentDist > remaining - 1) continue;

			dfs(nx, ny, path + dir[i], remaining - 1, n, m, r, c);
		}
	}
}

public class MiroSxxxt {
	public static void main(String[] args) {
		Solution2 sol= new Solution2();
		System.out.println(	sol.solution(3,4,2,3,3,1,5));
	}
}
