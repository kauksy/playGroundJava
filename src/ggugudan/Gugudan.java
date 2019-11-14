package ggugudan;

public class Gugudan {
	public static int[] calculate(int times, int limitNumber) {
		int[] result = new int[9];
		for (int i = 0; i < limitNumber; i++) {
			result[i] = times * (i + 1);
		}
		return result;
	}

	public static void print(int[] result, int times) {
		for (int i = 0; i < Input.second; i++) {
			System.out.println(times + " X " + (i + 1) + " = " + result[i]);
		}
		System.out.println("==========");
	}
}
