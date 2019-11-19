package calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 두 수를 입력하세요.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("1. 두 수의 합은 " + (a + b) + " 입니다.");
		System.out.println();
		
		System.out.println("2. 두 수를 입력하세요.");
		int num1, num2;
		String str1, str2;
		str1 = scan.next();
		str2 = scan.next();
		scan.close();

		num1 = Integer.parseInt(str1);
		num2 = Integer.parseInt(str2);
		// %d로 정수로 넣기
		System.out.printf("2. 두 수의 합은 %d 입니다.", num1 + num2);
		System.out.println();
		System.out.printf("두 수 %d, %d의 합은 %d 입니다.", num1, num2, num1 + num2);
	}

}
