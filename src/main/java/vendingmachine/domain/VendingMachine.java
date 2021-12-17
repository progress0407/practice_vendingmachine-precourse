package vendingmachine.domain;

import java.util.Map;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

import vendingmachine.repository.Buying;
import vendingmachine.repository.Coins;
import vendingmachine.repository.Items;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {

	private Coins coins;
	private Items items;
	private Buying buying;

	public void generateMachineCoins() {
		int machineMoney = InputView.getMachineMoney();
		coins = new Coins(machineMoney);
		OutputView.printCoins(coins);
	}

	public void generateItem() {
		Set<Item> items = InputView.getItems();
		this.items = new Items(items);
/*
		for (Item item : items) {
			System.out.println("item = " + item);
		}
*/
	}

	public void processBuying() {
		int moneyToBuy = InputView.getMoneyToBuy();
		buying = new Buying(coins, items, moneyToBuy);
		int remainingMoney = buying.buyUntilNoMoney();
		Map<Coin, Integer> changes = buying.getChanges();
		OutputView.printChanges(changes, remainingMoney);
	}
}
