package vendingmachine.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.view.InputView;

public class Buying {

	private Coins coins;
	private Items items;
	private int money; // 의미 1. 사야할 돈 2. 반환받아야할 돈

	public Buying(Coins coins, Items items, int money) {
		this.coins = coins;
		this.items = items;
		this.money = money;
	}

	public int buyUntilNoMoney() {
		while (canBuy()) {
			Item item = InputView.getItemToBuy(items, money);
			money -= item.getPrice();
			items.minusStock(item);
		}
		return money;
	}

	private boolean canBuy() {
		int minimumPrice = items.getMinimumPrice();
		return money >= minimumPrice;
	}

	public Map<Coin, Integer> getChanges() {
		Map<Coin, Integer> remainingCoins = new LinkedHashMap<>();
		if(!canReturnChangesCompletely()) {
			return coins.get();
		}

		for (Coin coin : Coin.values()) {
			int changesCount = coins.returnMaximumCount(coin, money);
			remainingCoins.put(coin, changesCount);
		}
		return remainingCoins;
	}

	private boolean canReturnChangesCompletely() {
		int remainingMoneyOfCustomer = money;
		int totalMoneyInMachine = coins.getTotalMoney();
		return remainingMoneyOfCustomer < totalMoneyInMachine;
	}
}
