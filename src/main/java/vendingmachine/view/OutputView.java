package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.repository.Coins;

public class OutputView {

	public static final String OUTPUT_MACHINE_MONEY_COIN = "자판기가 보유한 동전";
	public static final String COIN_COUNT_UNIT = "개";
	public static final String DASH = " - ";

	public static void printCoins(Coins coins) {
		System.out.println(OUTPUT_MACHINE_MONEY_COIN);
		Map<Coin, Integer> coinMap = coins.get();
		for (Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
			Coin coinAmount = entry.getKey();
			Integer coinCount = entry.getValue();
			System.out.println(coinAmount + DASH + coinCount + COIN_COUNT_UNIT);
		}
	}
}
