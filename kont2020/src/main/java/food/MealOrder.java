package food;

/**
 * A wrapper class for keeping track of a bought meal.
 *
 * The class needs to store the name of meal, as well as the price
 * it was sold for. And a way of providing these to external users.
 * 
 */
public class MealOrder {

	private final String meal;
	private final double price;

	public MealOrder(String name, double price) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name is null/blank");
		}

		if (price < 0) {
			throw new IllegalArgumentException("Price can not be negative");
		}

		this.meal = name;
		this.price = price;
	}

	public String getMeal() {
		return meal;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "MealOrder [name=" + meal + ", price=" + price + "]";
	}
}
