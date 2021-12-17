package vendingmachine.util;

import java.util.regex.Pattern;

import vendingmachine.repository.Items;

public class ItemInputInputValidator extends InputValidator {

	public static final String INVALID_INPUT_ITEMS = ERROR_PREFIX + "상품 입력이 적절하지 못합니다.";
	private static final String INVALID_NOT_FOUND_ITEM = ERROR_PREFIX + "상품을 찾을 수 없습니다.";

	public static void validateItems(String input) {
		String regExp = "^\\[[\\w가-힣,;\\d\\[\\]]*\\]$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_INPUT_ITEMS);
		}
	}

	public static void validateItem(String input) {
		String regExp = "^[가-힣\\w,]*$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_INPUT_ITEMS);
		}
	}

	public static void validateItemExist(Items items, String input) {
		if (!items.isExist(input)) {
			throw new IllegalArgumentException(INVALID_NOT_FOUND_ITEM);
		}
	}
}
