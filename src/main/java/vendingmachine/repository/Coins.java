package vendingmachine.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class Coins {
	private Map<Coin, Integer> coins = new HashMap<>();

	public static Coins add(int machineMoney) {
		while (machineMoney != 0) {
			int randomAmount = Randoms.pickNumberInList(Coin.getAmountList());
			machineMoney -= randomAmount;

		}

	}
}
