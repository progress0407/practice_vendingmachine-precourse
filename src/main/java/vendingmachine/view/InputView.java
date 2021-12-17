package vendingmachine.view;

import static java.lang.System.*;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.repository.Items;
import vendingmachine.util.CoinInputInputValidator;
import vendingmachine.util.ItemInputInputValidator;

public class InputView {

	public static final String INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String INPUT_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String DELIMITER_ITEMS = ";";
	public static final String DELIMITER_ITEM = ",";
	public static final String INPUT_MONEY_TO_BUY = "투입 금액을 입력해 주세요.";
	public static final String INFO_CURRENT_MONEY_TO_BUY = "투입 금액: %s원\n";
	public static final String INPUT_ITEM_NAME_TO_BUY = "구매할 상품명을 입력해 주세요.";

	public static int getMachineMoney() {
		while (true) {
			try {
				out.println(INPUT_MACHINE_MONEY);
				String input = Console.readLine();
				CoinInputInputValidator.validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}

	public static Set<Item> getItems() {
		while (true) {
			try {
				out.println(INPUT_ITEMS);
				String input = Console.readLine();
				ItemInputInputValidator.validateItems(input);
				return getItems(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}

	private static Set<Item> getItems(String input) {
		input = input.replaceAll("[\\[\\]]", "");
		String[] strings = input.split(DELIMITER_ITEMS);
		Set<Item> items = new HashSet<>();
		for (String string : strings) {
			ItemInputInputValidator.validateItem(string);
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
				out.println(INPUT_MONEY_TO_BUY);
				String input = Console.readLine();
				CoinInputInputValidator.validateMoneyToBuy(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}

	/**
	 * 투입 금액: 3000원
	 * 구매할 상품명을 입력해 주세요.
	 * 콜라
	 */
	public static Item getItemToBuy(Items items, int moneyToBuy) {
		while (true) {
			try {
				out.printf(INFO_CURRENT_MONEY_TO_BUY, moneyToBuy);
				out.println(INPUT_ITEM_NAME_TO_BUY);
				String input = Console.readLine();
				ItemInputInputValidator.validateItemExist(items, input);
				return items.findItemByName(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}
}
