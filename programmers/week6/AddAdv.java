package com.example.programmers.week6;

import java.util.Arrays;

public class AddAdv {

		public String solution(String play_time, String adv_time, String[] logs) {
			int playTime = timeToInt(play_time);
			int advTime = timeToInt(adv_time);
			int[] times = new int[360_000];
			for (String log : logs) {
				String[] splitLog = log.split("-");
				int startTime = timeToInt(splitLog[0]);
				int endTime = timeToInt(splitLog[1]);
				for (int i = startTime; i < endTime; i++) {
					times[i]++;
				}
			}

			int maxIdx = 0;
			long total = 0;
			for (int i = 0; i < advTime; i++) {
				total += times[i];
			}
			long maxTotalTime = total;
			for (int i = advTime; i < playTime; i++) {
				total += times[i] - times[i - advTime];
				if (total > maxTotalTime) {
					maxTotalTime = total;
					maxIdx = i - advTime + 1;
				}
			}

			return timeToString(maxIdx);
		}

		int timeToInt(String strTime) {
			int[] HMS = Arrays.stream(strTime.split(":"))
				.mapToInt(Integer::parseInt)
				.toArray();

			return 3600 * HMS[0] + 60 * HMS[1] + HMS[2];
		}

		static String timeToString(int time) {
			String t = "";
			int hour = time/3600;
			time %= 3600;
			if(hour <10) t+= "0"+ hour +":";
			else t += hour+":";

			int minute = time/60;
			time %= 60;
			if(minute <10) t+= "0"+ minute+":";
			else t += minute+":";

			int second = time;
			if(second <10) t+= "0"+ second;
			else t += second;

			return t;
		}
}


