package vendingmachine.util;

public class CoinInputInputValidator extends InputValidator {



	public static void validateMachineMoney(String input) {
		isDigit(input);
		isMultipleOfTen(input);
		isPositive(input);
	}

	public static void validateMoneyToBuy(String input) {
		isDigit(input);
		isMultipleOfTen(input);
	}

	public static void validateItemName(String input) {
		isDigit(input);
		isMultipleOfTen(input);
	}

}