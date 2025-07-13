package com.example.programmers.week5;

public class EntranceChecker {

	public static String checkEntrance(Object input) {
		if (!(input instanceof Integer)) {
			return "invalid input";
		}

		int age = (Integer) input;

		if (age <= 0) {
			return "invalid input";
		}

		if (age > 100) {
			return "Too old";
		}

		if (age < 10) {
			return "입장 불가";
		} else if (age <= 15) {
			return "보호자 동반 시 입장 가능";
		} else if (age <= 80) {
			return "혼자 입장 가능";
		} else { // age between 81 and 100
			return "보호자 동반 시 입장 가능";
		}
	}

	public static void main(String[] args) {
		// 테스트 예시
		System.out.println(checkEntrance(8));     // 입장 불가
		System.out.println(checkEntrance(12));    // 보호자 동반 시 입장 가능
		System.out.println(checkEntrance(30));    // 혼자 입장 가능
		System.out.println(checkEntrance(85));    // 보호자 동반 시 입장 가능
		System.out.println(checkEntrance(101));   // Too old
		System.out.println(checkEntrance(-3));    // invalid input
		System.out.println(checkEntrance("12"));  // invalid input
	}
}
