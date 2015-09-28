package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	private final Hand fullHouse = new Hand("Test AceClubs AceSpades TwoDiamonds TwoSpades TwoClubs"); 
	private final Hand emptyHand = new Hand("Empty AceClubs ThreeSpades FiveDiamonds TenHearts QueenSpades");
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
	
	@Test
	public void testHasPair(){ 
		assertTrue(fullHouse.hasPair()>0);
		assertFalse(emptyHand.hasPair()>0);
	}

	@Test
	public void testHasTriple(){
		assertTrue(fullHouse.hasTriple()>0);
		assertFalse(emptyHand.hasTriple()>0);
	}

	@Test
	public void testIsFullHouse(){
		assertTrue(fullHouse.isFullHouse());
		assertFalse(emptyHand.isFullHouse());
	}
	
}
