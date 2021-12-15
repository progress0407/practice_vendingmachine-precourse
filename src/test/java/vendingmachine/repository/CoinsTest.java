package vendingmachine.repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.util.InputValidator;

class CoinsTest {

	@ParameterizedTest
	@ValueSource(strings = {"12a", "124"})
	void 코인입력_예외(String input) {
		assertThatThrownBy(() -> InputValidator.validateMachineMoney(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR] ");
	}


}