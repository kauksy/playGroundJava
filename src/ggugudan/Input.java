package ggugudan;

import java.util.Scanner;

public class Input {
	static int first = 0;
	static int second = 0;

	public static void input() {
		// 1. 사용자 입력 문자열로 받기
		Scanner scan = new Scanner(System.in);
		String inputValue = scan.nextLine();

		// 2. 사용자가 입력한 값을 ','쉼표 기준으로 분리하기
		String[] splitedValue = inputValue.split(",");

		first = Integer.parseInt(splitedValue[0]);
		second = Integer.parseInt(splitedValue[1]);

	}

}
