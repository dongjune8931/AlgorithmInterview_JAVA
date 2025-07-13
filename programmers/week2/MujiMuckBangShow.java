package com.example.programmers.week2;

import java.util.*;

class Solution {
	public int solution(int[] food_times, long k) {
		List<Food> foods = new ArrayList<>();
		int len = food_times.length;
		for(int i = 0; i < len; i++) {
			foods.add(new Food(i + 1, food_times[i]));
		}
		foods.sort((o1, o2) -> o1.time - o2.time);

		int current_time = 0;
		int idx = 0;
		for(Food f : foods) {
			long diff = f.time - current_time;
			if(diff != 0) {
				long spend = diff * len;
				if(spend <= k) {
					k -= spend;
					current_time = f.time;
				} else {
					k %= len;
					foods = foods.subList(idx, food_times.length);
					foods.sort((o1,o2) ->o1.num - o2.num);
					return foods.get((int)k).num;

				}
			}
			idx++;
			len--;
		}
		return -1;
	}

	public class Food {
		int num, time;

		public Food(int num, int time) {
			this.num = num;
			this.time = time;
		}

	}


	class Solution2{
		public int solution(int[] food_times, long k) {
			int n = food_times.length;

			int[][] foodArr = new int[n][2];
			for (int i = 0; i < n; i++) {
				foodArr[i][0] = food_times[i];
				foodArr[i][1] = i + 1;
			}

			Arrays.sort(foodArr, Comparator.comparingInt(a -> a[0]));

			int previous = 0;
			for (int i = 0; i < n; i++) {
				int diff = foodArr[i][0] - previous;
				if (diff != 0) {
					long spend = (long) diff * (n - i);
					if (spend <= k) {
						k -= spend;
						previous = foodArr[i][0];
					} else {
						k %= (n - i);
						Arrays.sort(foodArr, i, n, Comparator.comparingInt(a -> a[1]));
						return foodArr[i + (int)k][1];
					}
				}
			}

			return -1;
		}
	}
	class Solution3{
		public int solution(int[] food_times, long k) {
			Queue<Food> queue = new LinkedList<>();

			for (int i = 0; i < food_times.length; i++) {
				queue.offer(new Food(i + 1, food_times[i]));
			}

			long time = 0;
			while (time < k) {
				if (queue.isEmpty()) return -1;

				Food current = queue.poll();

				if (current.remainTime > 0) {
					current.remainTime--;
					time++;

					if (current.remainTime > 0) {
						queue.offer(current);
					}
				}
			}

			if (queue.isEmpty()) return -1;

			return queue.peek().number;
		}

		static class Food {
			int number;
			int remainTime;

			public Food(int number, int remainTime) {
				this.number = number;
				this.remainTime = remainTime;
			}
		}
	}

	class Soltion4{
		public int solution(int[] food_times, long k) {
			int n = food_times.length;

			int[][] foodArr = new int[n][2];
			for (int i = 0; i < n; i++) {
				foodArr[i][0] = food_times[i];
				foodArr[i][1] = i + 1;
			}

			Arrays.sort(foodArr, Comparator.comparingInt(a -> a[0]));
			int cnt;
			while(k<n){
				cnt=n;
				for(int i=0;i<n;i++){
					if(foodArr[i][0]==0){
						cnt--;
					}
				}
				k=k-cnt;

			}
			return foodArr[(int)k][1];


		}

	}

}

public class MujiMuckBangShow {
	public static void main(String[] args) {

	}
}
