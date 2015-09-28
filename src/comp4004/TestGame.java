package comp4004;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void test() {
		String s = "";
		Game g = new Game(s);
		assertTrue(g.getHands().size()==2);
	}

}
