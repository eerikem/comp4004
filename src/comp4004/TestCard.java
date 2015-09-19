package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCard {

	@Test
	public void test() {
		Card c = new Card("TwoClubs");
		assertEquals( 2, c.getValue());
		assertEquals( "Clubs", c.getSuite());
	}

}
