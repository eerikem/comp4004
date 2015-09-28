package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHand {

	private final Hand fullHouse = new Hand("Test AceClubs AceSpades TwoDiamonds TwoSpades TwoClubs"); 
	private final Hand emptyHand = new Hand("Empty AceClubs ThreeSpades FiveDiamonds TenHearts QueenSpades");
	private final Hand twoPair = new Hand("FourHigh TwoClubs TwoSpades FourClubs FourSpades ThreeDiamonds");
	private final Hand aces = new Hand("Aces AceSpades AceDiamonds AceClubs AceHearts KingHearts");
	private final Hand straightFlush = new Hand("StrghtFlsh JackHearts TenHearts NineHearts EightHearts SevenHearts");
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

	@Test
	public void testIsTwoPair(){
		assertTrue(twoPair.isTwoPair()>0);
		assertFalse(emptyHand.isTwoPair()>0);
	}
	
	@Test
	public void testIsFourOfKind(){
		assertTrue(aces.isFourOfKind()>0);
	}
	
	@Test
	public void testHighCard(){
		assertTrue(emptyHand.getHighCard()==14);
	}
	
	@Test
	public void testIsStraight(){
		assertTrue(straightFlush.isStraight()>0);
		assertFalse(emptyHand.isStraight()>0);
	}
	
	@Test
	public void testIsFlush(){
		assertTrue(straightFlush.isFlush()>0);
		assertFalse(emptyHand.isFlush()>0);
	}
	
}
