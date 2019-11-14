package gugudan;

public class Gugudan {

	/**
	 * 요구사항1을 구현한 메소드
	 */
	public static void gugudan1() {
		System.out.println("최종요구사항1 수행");
		for (int i = 2; i < Input.gugudan1 + 1; i++) {
			for (int j = 1; j < Input.gugudan1 + 1; j++) {
				System.out.println(i + " X " + j + " = " + (i * j));
			}
			System.out.println("============");
		}
	}

	/**
	 * 요구사항2를 구현한 메소드
	 */
	public static void gugudan2() {
		System.out.println("최종요구사항2 수행");
		for (int i = 2; i < Input.first + 1; i++) {
			for (int j = 1; j < Input.second + 1; j++) {
				System.out.println(i + " X " + j + " = " + (i * j));
			}
			System.out.println("=============");
		}
	}
}