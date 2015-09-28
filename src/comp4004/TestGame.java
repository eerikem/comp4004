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
		String s = TestHand.emptyHand+" "+TestHand.fullHouse+" "+TestHand.twoPair+" "+TestHand.aces;
		String r = TestHand.aces+" "+TestHand.fullHouse+" "+TestHand.twoPair+" "+TestHand.emptyHand;
		Game g = new Game(s);
		assertTrue(g.rank().equals(r));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNumPlayers(){
		new Game(TestHand.fullHouse.toString());
		new Game(TestHand.emptyHand+" "+TestHand.fullHouse+" "+TestHand.twoPair+" "+TestHand.aces+" "+TestHand.lowStraight);
	}
}
