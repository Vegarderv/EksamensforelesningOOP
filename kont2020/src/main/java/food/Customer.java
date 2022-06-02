package food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import food.def.ICustomer;

public class Customer implements ICustomer {

	private final String name;
	private final Collection<MealOrder> orders;
	private MealOrder lastOrder = null;
		
	/**
	 * Create a new customer
	 * 
	 * @param name The name of the customer
	 */
	public Customer(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name is null/blank");
		}

		this.name = name;
		this.orders = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return A list containing all meals bought by this customer
	 */
	public Collection<MealOrder> getMealsOrdered() {
		return new ArrayList<>(this.orders);
	}

	/**
	 * Add a bought meal to this customer
	 * 
	 * @param meal The name of the meal
	 * @param price The price the customer paid for the meal
	 */
	@Override
	public void buyMeal(String meal, double price) {
		MealOrder order = new MealOrder(meal, price);
		this.orders.add(order);
		this.lastOrder = order;
	}
	
	
	/**
	 * @return The number of meals ordered by this customer
	 */
	@Override
	public int getNumberOfOrderedMeals() {
		return this.orders.size();
	}
	
	/**
	 * @return The name of this customer
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return A String on the form "<name>: <number of meals ordered>"
	 */
	@Override
	public String toString() {
		return this.getName() + ": " + this.getNumberOfOrderedMeals();
	}

	/**
	 * @return The most recent meal bought by this customer
	 * If no meal is ordered, return null.
	 */
	@Override
	public MealOrder getLastOrderedMeal() {
		return this.lastOrder;
	}
	
	/**
	 * Get the number of times the customer has eaten the given meal
	 * 
	 * @param meal The name of the meal
	 * 
	 * @return The number of times this customer has eaten the given meal
	 */
	@Override
	public int timesEaten(String meal) {
		if (meal == null || meal.isBlank()) {
			throw new IllegalArgumentException();
		}

		return (int) this.orders.stream()
			.filter(order -> order.getMeal().equals(meal))
			.count();
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer("Frank");
		customer.buyMeal("pancakes", 100);
		customer.buyMeal("pancakes", 75);
		System.out.println("Skal være 2 kjøp: " + customer.getMealsOrdered().size());
		System.out.println("Skal være pris 75: " + customer.getLastOrderedMeal().getPrice()); // Som definert i README.
	}
}
