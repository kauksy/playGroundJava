package ggugudan;

public class GugudanMain {

	public static void main(String[] args) {
		Input.input();
		for (int j = 2; j < Input.first + 1; j++) {
			int[] result = Gugudan.calculate(j, Input.second);
			Gugudan.print(result, j); 
		}
	}
}
