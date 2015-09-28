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

	public int isFourOfKind() {
		for(Card c:cards){
			ArrayList<Card> crds = new ArrayList<Card>(cards);
			crds.remove(c);
			Card d = pair(c,crds);
			if(d!= null){
				crds.remove(d);
				Card b = pair(c,crds);
				if(b!=null){
					crds.remove(b);
					if(pair(c,crds)!=null)return c.getValue();
				}
			}
		}
		return 0;
	}

	public int getHighCard() {
		int high = 0;
		for(Card c:cards){
			if(c.getValue()>high)high=c.getValue();
		}
		return high;
	}

	public int isTwoPair() {
		int pair = hasPair();
		if (pair > 0) {
			ArrayList<Card> crds = new ArrayList<Card>(cards);
			for (Card c : crds) {
				if (c.getValue() != pair) {
					int p = pair(c, crds).getValue();
					if (p > 0){
						if(pair>p)return pair;
						else return p;
					}
				}
			}
		}
		return 0;
	}

	public int isStraight() {
		int high = getHighCard();
		int x = 0;
		for(Card c:cards){
			x += high - c.getValue();
		}
		if(x==10)return high;
		if(x==42)return 5;
		return 0;
	}

	public int isFlush() {
		String suite = cards.get(0).getSuite();
		for(Card c:cards){
			if(!c.getSuite().equals(suite))return 0;
		}
		return getHighCard();
	}

	public String toString(){
		String r = player;
		for(Card c:cards){
			r+= " "+c;
		}
		return r;
	}

	public boolean trumps(Hand hand) {
		return rankHand()>hand.rankHand();
	}
	
	private int rankHand(){
		if(isFlush()>0){
			if(isStraight()>0){
				return 8;
			}else{
				return 5;
			}
		}else{
			if(isStraight()>0){
				return 4;
			}
		}
		if(isFourOfKind()>0){
			return 7;
		}else if(isFullHouse()){
				return 6;
			}else if(hasTriple()>0){
				return 3;
		}else if(isTwoPair()>0){
			return 2;
		}else if(hasPair()>0){
			return 1;}
		else{
			return 0;
		}
	}
	
}
