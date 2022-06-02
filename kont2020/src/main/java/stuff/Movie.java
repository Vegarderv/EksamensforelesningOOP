package stuff;

import static org.junit.Assert.assertEquals;

public class Movie {

	// See the README file for a description of what is required for this file.
	private String title;
	private int timesWatched;
	private Integer rating;

	public Movie(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title kan ikke være null");
		}

		this.title = title;
		this.timesWatched = 0;

	}

	public Movie(String title, Integer rating) {
		this(title);
		setRating(rating);
	}

	public Integer getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public void setRating(int rating) {
		if (!(rating >= 1 && rating <= 6)) {
			throw new IllegalArgumentException();
		}
		this.rating = rating;
	}

	public int getTimesWatched() {
		return timesWatched;
	}

	public void watch() {
		timesWatched++;
	}

	public static void main(String[] args) {

		Movie db = new Movie("Das Boot");
		assertEquals(0, db.getTimesWatched());
		assertEquals("Das Boot", db.getTitle());
		
		db.watch();
		assertEquals(1, db.getTimesWatched());
		
		assertEquals(null, db.getRating());
		db.setRating(4);
		assertEquals(4, (int)db.getRating());
	}

}
