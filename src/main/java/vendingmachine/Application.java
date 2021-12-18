package vendingmachine;

import vendingmachine.repository.CoinRepository;
import vendingmachine.strategy.coin.ConsoleCoinInputStrategy;

public class Application {
    public static void main(String[] args) {
        CoinRepository.setCoinInputStrategy(new ConsoleCoinInputStrategy());
        CoinRepository.add();
    }
}
