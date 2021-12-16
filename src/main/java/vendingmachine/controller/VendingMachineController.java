package vendingmachine.controller;

import java.util.Set;

import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController {

	public void run() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.processMachineMoney();
		vendingMachine.processItem();


		int moneyToBuy = InputView.getMoneyToBuy();
	}
}
