package vendingmachine.view;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.util.InputValidator;

public class InputView {

	public static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String DELIMITER_ITEMS = ";";
	public static final String DELIMITER_ITEM = ",";
	public static final String INPUT_MONEY_TO_BUY = "투입 금액을 입력해 주세요.";

	public static int getMachineMoney() {
		while (true) {
			try {
				System.out.println(INPUT_MACHINE_MONEY);
				String input = Console.readLine();
				InputValidator.validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static Set<Item> getItems() {
		while (true) {
			try {
				System.out.println(INPUT_ITEMS);
				String input = Console.readLine();
				InputValidator.validateItems(input);
				return getItems(input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static Set<Item> getItems(String input) {
		input = input.replaceAll("[\\[\\]]", "");
		String[] strings = input.split(DELIMITER_ITEMS);
		Set<Item> items = new HashSet<>();
		for (String string : strings) {
			InputValidator.validateItem(string);
			Item item = getItem(string);
			items.add(item);
		}
		return items;
	}

	private static Item getItem(String input) {
		String[] strings = input.split(DELIMITER_ITEM);
		String name = strings[0];
		int price = Integer.parseInt(strings[1]);
		int count = Integer.parseInt(strings[2]);
		return new Item(name, price, count);
	}

	public static int getMoneyToBuy() {
		while (true) {
			try {
				System.out.println(INPUT_MONEY_TO_BUY);
				String input = Console.readLine();
				InputValidator.validateMoneyToBuy(input);
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
