package vendingmachine.view;

import java.util.Map;
import java.util.Set;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.repository.Coins;
import vendingmachine.repository.Items;

public class OutputView {

	public static final String OUTPUT_MACHINE_MONEY_COIN = "자판기가 보유한 동전";
	public static final String COIN_COUNT_UNIT = "개";
	public static final String DASH = " - ";
	public static final String OUTPUT_CHANGES = "투입 금액: %d원\n잔돈\n";

	public static void printMachineCoins(Coins coins) {
		System.out.println(OUTPUT_MACHINE_MONEY_COIN);
		Map<Coin, Integer> coinMap = coins.get();
		printCoinMap(coinMap);
	}

	private static void printCoinMap(Map<Coin, Integer> coinMap) {
		for (Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
			Coin coinAmount = entry.getKey();
			Integer coinCount = entry.getValue();
			System.out.println(coinAmount + DASH + coinCount + COIN_COUNT_UNIT);
		}
	}

	/**
	 * 투입 금액: 500원
	 * 잔돈
	 */
	public static void printChanges(Map<Coin, Integer> changes, int remainingMoney) {
		System.out.printf(OUTPUT_CHANGES, remainingMoney);
		printCoinMap(changes);
	}

	public static void printItems(Items items) {
		Set<Item> itemSet = items.get();
		for (Item item : itemSet) {
			System.out.println("item = " + item);
		}
	}
}
