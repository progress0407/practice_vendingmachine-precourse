package vendingmachine.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.util.CoinInputInputValidator;
import vendingmachine.util.ItemInputInputValidator;

class CoinsTest {

	public static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";

	@ParameterizedTest
	@ValueSource(strings = {"12a", "124"})
	void 코인입력_예외(String input) {
		assertThatThrownBy(() -> CoinInputInputValidator.validateMachineMoney(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_PREFIX_MESSAGE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1000,10],[사이다,500,50];", "[콜라,1000,10],[사이다,500,50"})
	void 상품명_입력_예외(String input) {
		assertThatThrownBy(()->{
			ItemInputInputValidator.validateItems(input);
		})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_PREFIX_MESSAGE);;
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,1000,10];", "콜라,1000,10]", "[콜라,1000]"})
	void 상품명_입력_예외2(String input) {
		assertThatThrownBy(()->{
			ItemInputInputValidator.validateItem(input);
		})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_PREFIX_MESSAGE);;
	}


}