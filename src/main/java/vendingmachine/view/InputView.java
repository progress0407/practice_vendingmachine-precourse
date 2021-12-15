package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.InputValidator;

public class InputView {

	public static int getInputMachineMoney() {
		while (true) {
			try {
				System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
				String input = Console.readLine();
				InputValidator.validateMachineMoney(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
