package vendingmachine.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class Coins {
	private Map<Coin, Integer> coins = new LinkedHashMap<>();

	{
		coins.put(Coin.COIN_500, 0);
		coins.put(Coin.COIN_100, 0);
		coins.put(Coin.COIN_50, 0);
		coins.put(Coin.COIN_10, 0);
	}

	public Coins(int machineMoney) {
		while (machineMoney != 0) {
			Coin randomCoin = getRandomCoin();
			if (canSubtract(randomCoin, machineMoney)) {
				machineMoney -= randomCoin.getAmount();
				addCount(randomCoin);
			}
		}
	}

	public Map<Coin, Integer> get() {
		return coins;
	}

	private boolean canSubtract(Coin randomCoin, int machineMoney) {
		return machineMoney - randomCoin.getAmount() >= 0;
	}

	private Coin getRandomCoin() {
		int randomAmount = Randoms.pickNumberInList(Coin.getAmountList());
		Coin coin = Coin.of(randomAmount);
		return coin;
	}

	private void addCount(Coin coin) {
		Integer count = coins.get(coin);
		coins.replace(coin, count + 1);
	}

	public int getTotalMoney() {
		int total = 0;
		for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
			int subTotal = getSubTotal(entry);
			total += subTotal;
		}
		return total;
	}

	private int getSubTotal(Map.Entry<Coin, Integer> entry) {
		int coinAmount = entry.getKey().getAmount();
		Integer coinCount = entry.getValue();
		return coinAmount * coinCount;
	}

	public int returnMaximumCount(Coin coin, int money) {
		int currentCoinCount = coins.get(coin);
		int coinCountToReturn = money / coin.getAmount() ;
		return Math.min(currentCoinCount, coinCountToReturn);
	}
}
