package com.example.programmers.week4;
import java.util.*;

class Solution {
	static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static boolean[] visited = new boolean[8]; //방문여부 체크
	static char[] order = new char[8]; //지금 세운 순서
	static int count = 0;

	public int solution(int n, String[] data) {
		count = 0;
		dfs(0, data);
		return count;
	}

	private void dfs(int depth, String[] data) {
		if (depth == 8) {
			if (isValid(data)) count++;
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			order[depth] = friends[i];
			dfs(depth + 1, data);
			visited[i] = false;
		}
	}

	private boolean isValid(String[] data) {
		Map<Character, Integer> pos = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			pos.put(order[i], i);
		}

		for (String cond : data) {
			char a = cond.charAt(0);
			char b = cond.charAt(2);
			char op = cond.charAt(3);
			int dist = cond.charAt(4) - '0';

			int gap = Math.abs(pos.get(a) - pos.get(b)) - 1;

			if (op == '=' && gap != dist) return false;
			if (op == '<' && gap >= dist) return false;
			if (op == '>' && gap <= dist) return false;
		}
		return true;
	}

}
public class takePicture {
}
