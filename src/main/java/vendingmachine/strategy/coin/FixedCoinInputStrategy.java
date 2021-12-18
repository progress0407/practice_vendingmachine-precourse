package vendingmachine.strategy.coin;

public class FixedCoinInputStrategy implements CoinInputStrategy {

	private String coinInput;

	public FixedCoinInputStrategy(String coinInput) {
		this.coinInput = coinInput;
	}

	@Override
	public String input() {
		System.out.println("입력됨: coinInput = " + coinInput);
		return coinInput;
	}
}
