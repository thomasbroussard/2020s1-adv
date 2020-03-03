package fr.epita.maths;

public class FactorialService {

	public int calculateFactorial(int integer) {
		if (integer <= 0) {
			throw new IllegalArgumentException("negative values are not accepted");
		}
		int result = integer;
		for (int i = integer - 1 ; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	
}
