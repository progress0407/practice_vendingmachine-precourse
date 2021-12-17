package vendingmachine.domain;

import java.util.Objects;

public class Item implements Comparable<Item> {

	private String name;
	private int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public boolean equalsName(String inputName) {
		return name.equals(inputName);
	}

	public void minusStock() {
		count--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Item))
			return false;
		Item item = (Item)o;
		return getPrice() == item.getPrice() && count == item.count && Objects.equals(name, item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, getPrice(), count);
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", count=" + count +
			'}';
	}

	@Override
	public int compareTo(Item o) {
		return this.name.compareTo(o.name);
	}
}
