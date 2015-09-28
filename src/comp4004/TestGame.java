package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void test() {
		String s = TestHand.twoPair + " " + TestHand.emptyHand;
		Game g = new Game(s);
		assertTrue(g.getHands().size()==2);
	}
	
	@Test
	public void testRank(){
		String s = TestHand.twoPair + " " + TestHand.emptyHand;
		Game g = new Game(s);
		assertTrue(g.rank().equals(s));
	}
}
