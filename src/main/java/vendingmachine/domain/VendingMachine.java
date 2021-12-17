package vendingmachine.domain;

import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

import vendingmachine.repository.Coins;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {

	private int machineMoney;
	private Set<Item> items;
	private int moneyToBuy;

	public void processMachineMoney() {
		int machineMoney = InputView.getMachineMoney();
		Coins coins = new Coins(machineMoney);
		OutputView.printCoins(coins);
	}

	public void processItem() {
		Set<Item> items = InputView.getItems();
		for (Item item : items) {
			System.out.println("item = " + item);
		}
	}
}
