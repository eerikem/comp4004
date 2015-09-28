package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	@Test
	public void test() {
		Hand h = new Hand("Pierre FiveHearts TwoDiamonds QueenSpades FourClubs AceHearts");
		assertTrue(h.getPlayer()=="Pierre");
		assertTrue(h.getCards().size()==5);
	}

}
