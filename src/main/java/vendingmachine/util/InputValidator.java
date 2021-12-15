package vendingmachine.util;

import java.util.regex.Pattern;

public class InputValidator {

	public static final String INVALID_INPUT_MONEY = "[ERROR] 숫자를 입력해야 합니다.";
	public static final String INVALID_INPUT_TEN_OF_MULTIPLE = "[ERROR] 10의 배수를 입력해야 합니다.";
	public static final String INVALID_INPUT_ITEMS = "[ERROR] 상품 입력이 적절하지 못합니다.";

	public static void validateMachineMoney(String input) {
		isDigit(input);
		isMultipleOfTen(input);
	}

	private static void isMultipleOfTen(String input) {
		int inputInt = Integer.parseInt(input);
		if (inputInt % 10 != 0) {
			throw new IllegalArgumentException(INVALID_INPUT_TEN_OF_MULTIPLE);
		}
	}

	private static void isDigit(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_INPUT_MONEY);
		}
	}

	public static void validateItems(String input) {
		String regExp = "^\\[[\\[\\]\\w가-힣,;\\d]*\\]$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_INPUT_ITEMS);
		}
	}

	public static void validateItem(String input) {
		String regExp = "^\\[[\\w가-힣]*,\\d+,\\d+\\]$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_INPUT_ITEMS);
		}
	}
}