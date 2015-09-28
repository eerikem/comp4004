package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	@Test
	public void test() {
		Hand h = new Hand("Pierre FiveHearts TwoDiamonds QueenSpades FourClubs AceHearts");
		assertTrue(h.getPlayer().equals("Pierre"));
		assertTrue(h.getCards().size()==5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidHands(){
		new Hand("Frank FiveHearts TwoDiamonds QueenSpades");
		new Hand("Billy FiveHearts TwoDiamonds QueenSpades FourClubs");
		new Hand("Thatcher FiveHearts TwoDiamonds QueenSpades FourClubs badarg");
	}

}
