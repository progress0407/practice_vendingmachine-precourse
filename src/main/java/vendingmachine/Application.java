package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        int machineMoney = InputView.getMachineMoney();
        InputView.getItems();
        VendingMachine vendingMachine = new VendingMachine();

    }
}
