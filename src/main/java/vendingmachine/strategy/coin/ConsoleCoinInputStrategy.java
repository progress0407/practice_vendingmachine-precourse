package vendingmachine.strategy.coin;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.InputView;

public class ConsoleCoinInputStrategy implements CoinInputStrategy {

	@Override
	public String input() {
		InputView.inputCoin();
		String consoleInput = Console.readLine();
		System.out.println("consoleInput = " + consoleInput);
		return consoleInput;
	}
}
