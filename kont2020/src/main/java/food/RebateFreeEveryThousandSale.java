package food;

import food.def.PriceProvider;

/**
 * A rebate where every thousandth purchase (regardless of meal, price, or customer)
 * is given away for free. Not the first buy!
 */
public class RebateFreeEveryThousandSale implements PriceProvider {

	private int counter;

	@Override
	public double providePrice(String meal, double price, Customer customer) {
		counter ++;
		return counter % 1000 == 0 ? 0 : 1;
		/*
		 * Det samme som:
		 * If (counter % 1000 == 0) {
		 * 	return 0;
		 * } else {
		 * 	return 1;
		 * }
		 */
	}


}
