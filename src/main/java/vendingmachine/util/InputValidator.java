package vendingmachine.util;

public class InputValidator {

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INVALID_INPUT_MONEY = ERROR_PREFIX + "숫자를 입력해야 합니다.";
	public static final String INVALID_INPUT_TEN_OF_MULTIPLE = ERROR_PREFIX + "10의 배수를 입력해야 합니다.";

	protected static void isPositive(String input) {
		int inputInt = Integer.parseInt(input);
		if (inputInt <= 0) {
			throw new IllegalArgumentException("");
		}
	}

	protected static void isMultipleOfTen(String input) {
		int inputInt = Integer.parseInt(input);
		if (inputInt % 10 != 0) {
			throw new IllegalArgumentException(INVALID_INPUT_TEN_OF_MULTIPLE);
		}
	}

	protected static void isDigit(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_INPUT_MONEY);
		}
	}
}
