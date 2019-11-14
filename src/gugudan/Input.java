package gugudan;

import java.util.Scanner;

public class Input {
	static int gugudan1 = 0;
	static int first = 0;
	static int second = 0;
	
	static Scanner scan = new Scanner(System.in);

	/**
	 * 요구사항1에 대한 입력
	 */
	public static void inputGugudan1() {
		System.out.println("====요구사항 1에 대한 정보 입력====");
		gugudan1 = scan.nextInt();
	}

	/**
	 * 요구사항2에 대한 입력
	 */
	public static void inputGugudan2() {
		System.out.println("====요구사항 2에 대한 정보 입력====");
		String inputStr = scan.next();
		String[] str = inputStr.split(",");

		System.out.println(str[0]);
		System.out.println(str[1]);
		first = Integer.parseInt(str[0]);
		second = Integer.parseInt(str[1]);
	}

}
