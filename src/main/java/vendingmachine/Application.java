package vendingmachine;

import java.util.Set;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {

        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.run();

    }
}
