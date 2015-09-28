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

	public int hasPair() {
		for(Card c:cards){
			ArrayList<Card> crds = new ArrayList<Card>(cards);
			crds.remove(c);
			if(pair(c,crds)!=null)return c.getValue();
		}
		return 0;
	}
	
	private Card pair(Card c, ArrayList<Card> crds){
		for(Card card:crds){
			if(c.getValue()==card.getValue())
				return card;
		}
	return null;
	}

	public int hasTriple() {
		for(Card c:cards){
			ArrayList<Card> crds = new ArrayList<Card>(cards);
			crds.remove(c);
			Card d = pair(c,crds);
			if(d!= null){
				crds.remove(d);
				if(pair(c,crds)!=null)return c.getValue();
			}
		}
		return 0;
	}

	public boolean isFullHouse() {
		int triple = hasTriple();
		int pair = hasPair();
		if(triple > 0 && pair > 0 && triple != pair)
			return true;
		return false;
	}

}
