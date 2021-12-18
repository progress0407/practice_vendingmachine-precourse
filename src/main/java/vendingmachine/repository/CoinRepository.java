package vendingmachine.repository;

import java.util.Collections;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.strategy.coin.CoinInputStrategy;
import vendingmachine.view.InputView;

public class CoinRepository {
	private static Map<Coin, Integer> coins;

	private static CoinInputStrategy coinInputStrategy;

	public static void setCoinInputStrategy(CoinInputStrategy coinInputStrategy) {
		CoinRepository.coinInputStrategy = coinInputStrategy;
	}

	public static Map<Coin, Integer> coins() {
		return Collections.unmodifiableMap(coins);
	}

	public static void add() {
		String coinInput = coinInputStrategy.input();
	}

}
