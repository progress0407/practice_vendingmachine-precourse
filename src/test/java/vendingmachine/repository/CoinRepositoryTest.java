package vendingmachine.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vendingmachine.strategy.coin.CoinInputStrategy;
import vendingmachine.strategy.coin.FixedCoinInputStrategy;

class CoinRepositoryTest {

	@Test
	void 코인입력() {
		FixedCoinInputStrategy fixedCoinInputStrategy = new FixedCoinInputStrategy("123");
		CoinRepository.setCoinInputStrategy(fixedCoinInputStrategy);
		CoinRepository.add();
	}
}