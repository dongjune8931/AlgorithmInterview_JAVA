package com.example.programmers.week3;

import java.util.Arrays;

class Solution {
	public int solution(int[][] info, int n, int m) {
		int answer = 0;

		for (int i = 0; i < info.length - 1; i++) {
			for (int j = i + 1; j < info.length; j++) {
				if (info[i][0] < info[j][0] ||
					(info[i][0] == info[j][0] && info[i][1] > info[j][1])) {
					int[] temp = info[i];
					info[i] = info[j];
					info[j] = temp;
				}
			}
		}

		for (int[] in : info) {
			if (m - in[1] > 0) {
				m -= in[1];
			}
			else {
				if (n - in[0] > 0) {
					n -= in[0];
					answer += in[0];
				} else return -1;
			}
		}

		return answer;

	}
}

public class PerfectCriminal {
	/**
	 *  흔적의 개수는 1~3 : info[i][0 or 1]
	 * info[i]는 물건 i를 훔칠 때 생기는 흔적의 개수를 나타내며, [A에 대한 흔적 개수, B에 대한 흔적 개수]의 형태입니다.
	 *  n: A 도둑의 완전범죄 실패가 되는 개수
	 *  m: B 도둑의 완전범죄 실패가 되는 개수
	 *  return
	 *  (1): 도둑 모두 경찰에 붙잡히지 않게 할 수없다! = -1
	 *  (2) : 둘다 붙잡히지 않을 때 A 도둑의 남긴 흔적누적 개수의 '최솟값'
	 */

	public static void main(String[] args) {
		Solution solution=new Solution();
		int[][] question = {{1, 2}, {2, 3}, {2, 1}};
		System.out.println(solution.solution(question, 4, 4));
	}
}


