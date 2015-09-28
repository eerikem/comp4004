package comp4004;

import java.util.ArrayList;

public class Hand {

	private String player;
	private ArrayList<Card> cards;
	
	public Hand(String rawHand) {
		cards = new ArrayList<Card>();
		String[] input = rawHand.split(" ");
		if(input.length!=6)throw new IllegalArgumentException("Bad Hand Provided");
		this.player = input[0];
		for(int x=1; x<=5;x++){
			cards.add(new Card(input[x]));
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public String getPlayer() {
		return player;
	}

}
