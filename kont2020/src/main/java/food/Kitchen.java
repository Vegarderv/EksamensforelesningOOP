package food;

import java.util.ArrayList;
import java.util.Collection;

import food.def.IKitchen;
import food.def.KitchenObserver;
import food.def.PriceProvider;

// Important: There is no similarity between Kitchen in the exam v2020 and this one.
public class Kitchen implements IKitchen {

	// Add internal variables here:
	private final Collection<String> recipes;
	private final Collection<Customer> customers;
	private double turnover;
	private final Collection<PriceProvider> rebates;
	private final Collection<KitchenObserver> observers;
	
	public Kitchen() {
		super();
		recipes = new ArrayList<>();
		customers = new ArrayList<>();
		rebates = new ArrayList<>();
		observers = new ArrayList<>();
	}
	
	
	/**
	 * Add a customer
	 * @param customer The customer to add
	 * 
	 * @throws IllegalArgumentException if the customer is already registered
	 */
	@Override
	public void addCustomer(Customer customer) {
		if (customer == null || customers.contains(customer)) {
			throw new IllegalArgumentException();
		}
		customers.add(customer);
	}

	/**
	 * Add a recipe
	 * @param recipe The recipe to add
	 */
	@Override
	public void addRecipe(String recipe) {
		if (recipe == null || recipes.contains(recipe)) {
			throw new IllegalArgumentException();
		}
		recipes.add(recipe);
	}
	
	/**
	 * @return The turnover of this kitchen - price of all sold meals added together
	 * If the restaurant has sold for 50, 75 and 100, the turnover is 225.
	 * (Norsk: omsetning)
	 */
	@Override
	public double getTurnover() {
		return turnover;
	}

	
	/**
	 * @return A collection of this kitchen's recipes
	 */
	@Override
	public Collection<String> getRecipes() {
		return new ArrayList<>(recipes);
	}
	
	/**
	 * @param name The name of the customer to get
	 * 
	 * @return The customer with the given name, or null if no such customer is registered
	 */
	public Customer getCustomer(String name) {
		return customers.stream().filter(customer -> customer.getName().equals(name)).findAny().orElse(null);
	}

	/**
	 * Make a meal, with a given (standard)price and to a given customer.
	 * 
	 * This method needs to check that the kitchen knows the given recipe
	 * and has the given customer registered.
	 * (Task 2.3): rebates need to be considered
	 * Finally, data about the sale must be registered in all appropriate places.
	 * 
	 * @param meal The name of the meal to make
	 * @param price The standard price of the meal
	 * @param customerName The name of the customer that buys the meal
	 * 
	 * @throws IllegalStateException if a meal is not successfully made (somehow)
	 */
	@Override
	public void provideMeal(String meal, double price, String customerName) {
		if(!recipes.contains(meal) || getCustomer(customerName) == null) {
			throw new IllegalStateException();
		}
		double finalPrice = computeActualPrice(meal, price, getCustomer(customerName));
		getCustomer(customerName).buyMeal(meal, finalPrice);
		turnover += finalPrice;
		observers.stream().forEach(obs -> obs.mealOrder(meal, finalPrice));
	}
		
	/**
	 * Exercise 2.3 - Delegation
	 * Calculate the total rebate of the given meal, using the priceDelegates of this Kitchen
	 * If more than one rebate exist, each of them applies. See README for example.
	 * 
	 * @param meal The name of the meal
	 * @param price The standard price of the meal
	 * @param customer The customer buying the meal
	 * @return The resulting price after all rebates have been considered.
	 */
	double computeActualPrice(String meal, double price, Customer customer) {
		return price * rebates.stream()
		.map(rebate -> rebate.providePrice(meal, price, customer))
		.reduce(1.0, (a, b) -> a * b);
	}
	
	// Exercise 2.3 - Delegation - these may not be all methods you need to create!
	@Override
	public void addPriceProvider(PriceProvider pp) {
		if (pp == null || rebates.contains(pp)){
			throw new IllegalArgumentException();
		}
		rebates.add(pp);
	}

	public void removePriceProvider(PriceProvider pp) {
		if (!rebates.contains(pp)) {
			throw new IllegalArgumentException();
		}
		rebates.remove(pp);
	}

	// Exercise 2.4 - Observerer - these may not be all methods you need to create!
	@Override
	public void addObserver(KitchenObserver ko) {
		if (ko == null || observers.contains(ko)) {
			throw new IllegalArgumentException();
		}
		observers.add(ko);
	}

	public void removeObserver(KitchenObserver ko) {
		if (ko == null || !observers.contains(ko)) {
			throw new IllegalArgumentException();
		}
		observers.remove(ko);
	}

	
	public static void main(String[] args) {
		Kitchen k = new Kitchen();
		k.addRecipe("pancakes");
		k.addRecipe("waffles");
		k.addRecipe("taco");
		k.addRecipe("spam");
		Customer per = new Customer("per");
		k.addCustomer(per);
//		k.addCustomer(per); // IllegalArgumentException
		k.addCustomer(new Customer("ida"));
		k.provideMeal("pancakes", 99.50, "per");
		System.out.println(k.getTurnover());
		k.provideMeal("pancakes", 50, "ida");
		System.out.println(k.getTurnover());
	}


}
