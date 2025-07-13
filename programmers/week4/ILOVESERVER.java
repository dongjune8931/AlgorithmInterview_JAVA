package com.example.programmers.week4;
class Solution3 {
	public int solution(int[] players, int m, int k) {

		int answer = 0;

		int[] active = new int[24];

		for (int hour = 0; hour < 24; hour++) {
			int required = players[hour] / m;

			if (required > active[hour]) {
				int need = required - active[hour];  // 새로 증설할 서버 대수
				answer += need;                      // 증설 횟수 누적


				for (int t = hour; t < hour + k && t < 24; t++) {
					active[t] += need;
				}
			}
		}

		return answer;
	}
}


public class ILOVESERVER {
	public static void main(String[] args) {

	}
}
