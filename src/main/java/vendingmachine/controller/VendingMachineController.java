package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

public class VendingMachineController {

	public void run() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.generateMachineCoins();
		vendingMachine.generateItem();
		vendingMachine.processBuying();
	}
}
