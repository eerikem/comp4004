package comp4004;

import java.util.ArrayList;

public class Game {

	private ArrayList<Hand> hands;
	
	public Game(String allPlayers) {
		hands= new ArrayList<Hand>();
		String[] input = allPlayers.split(" ");
		if(hasDuplicates(input))throw new IllegalArgumentException("All inputs must be unique.");
		if(input.length%6!=0)throw new IllegalArgumentException("Incorrect number of arguments passed to game.");
		int numPlayers = (input.length)/6;
		if(numPlayers<2||numPlayers>4)throw new IllegalArgumentException("Game must have 2 to 4 players.");
		String hand = input[0];
		for(int x = 1; x<input.length;x++){
			hand = hand + " " + input[x];
			if((x+1)%6==0){
				hands.add(new Hand(hand));
				x++;
				if(x<input.length)hand=input[x];
			}
		}
	}

	//Check for duplicate cards
	private boolean hasDuplicates(String[] cards){
		for(int x=0;x<cards.length;x++){
			for(int y=x+1;y<cards.length;y++){
				if(cards[x].equals(cards[y])){
					System.out.println("WARNING: Duplicated "+cards[x]);
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Hand> getHands() {
		return hands;
	}

	public String rank() {
		ArrayList<Hand> ranked = new ArrayList<Hand>();
		ranked.add(hands.get(0));
		for (int x = 1; x < hands.size(); x++) {
			Hand h = hands.get(x);
			boolean added = false;
			for (int y = ranked.size(); y > 0; y--) {
				if (!h.trumps(ranked.get(y - 1))) {
					ranked.add(y, h);
					added = true;
				}
			}
			if (!added)
				ranked.add(0, h);
		}
	
		String result = ranked.get(0).toString();
		for(int z = 1;z<ranked.size();z++){
			result+=" "+ranked.get(z);
		}
		print(ranked);
		return result;
	}
	
	private void print(ArrayList<Hand> hands){
		for(int x = 0; x<hands.size();x++){
			System.out.println((x+1)+" "+hands.get(x));
		}
	}

}
