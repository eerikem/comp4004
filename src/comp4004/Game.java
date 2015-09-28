package comp4004;

import java.util.ArrayList;

public class Game {

	private ArrayList<Hand> hands;
	
	public Game(String allPlayers) {
		hands= new ArrayList<Hand>();
		String[] input = allPlayers.split(" ");
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

	public ArrayList<Hand> getHands() {
		return hands;
	}
	
}
