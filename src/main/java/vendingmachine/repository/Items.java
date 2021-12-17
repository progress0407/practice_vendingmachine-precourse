package vendingmachine.repository;

import java.util.Set;

import vendingmachine.domain.Item;

public class Items {

	private Set<Item> items;

	public Items(Set<Item> items) {
		this.items = items;
	}

	public int getMinimumPrice() {
		return items.stream()
			.mapToInt(Item::getPrice)
			.min()
			.getAsInt();
	}

	public Item findItemByName(String inputName) {
		return items.stream()
			.filter(item -> item.equalsName(inputName))
			.findAny()
			.get();
	}

	public void minusStock(Item inputItem) {
		Item findItem = findItem(inputItem);
		findItem.minusStock();
	}

	private Item findItem(Item inputItem) {
		return items.stream()
			.filter(item -> item.equals(inputItem))
			.findAny()
			.get();
	}

	public boolean isExist(String input) {
		return items.stream()
			.anyMatch(item -> item.equalsName(input));
	}
}
