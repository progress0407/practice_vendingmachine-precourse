package vendingmachine.domain;

import java.util.Set;

import vendingmachine.repository.Coins;
import vendingmachine.view.InputView;

public class VendingMachine {

	private int machineMoney;
	private Set<Item> items;
	private int moneyToBuy;
	private Coins coins;

	public VendingMachine(int machineMoney, Set<Item> items, int moneyToBuy) {
		this.machineMoney = machineMoney;
		this.items = items;
		this.moneyToBuy = moneyToBuy;
	}

	public void processMachineMoney() {
		int machineMoney = InputView.getMachineMoney();
		this.coins = Coins.add(machineMoney);
	}

	public void processItem() {
		Set<Item> items = InputView.getItems();
	}
}
