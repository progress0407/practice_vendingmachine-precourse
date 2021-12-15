package vendingmachine.repository;

import vendingmachine.domain.Coin;

public class Coins {
	private Coin coin;
	private int count;

	public Coins(Coin coin, int count) {
		this.coin = coin;
		this.count = count;
	}

}
