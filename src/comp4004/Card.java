package comp4004;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Card {

	private static final ArrayList<String> numbers = new ArrayList<String>(
			Arrays.asList(null, null, "Two", "Three", "Four", "Five", "Six",
					"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King",
					"Ace"));
	private static final ArrayList<String> suites = new ArrayList<String>(
			Arrays.asList("Hearts","Clubs","Diamonds","Spades"));
	private int value;
	private String suite;
	
	public Card(String string) {
		String[] card = StringUtils.splitByCharacterTypeCamelCase(string);
		if (numbers.contains(card[0])){
			this.value = numbers.indexOf(card[0]);
		}else{
			throw new IllegalArgumentException("Improper Card Number");
		}
		this.suite = card[1];
		if(!suites.contains(suite))
			throw new IllegalArgumentException("Improper Suite");
			
	}

	public int getValue() {
		return value;
	}

	public String getSuite() {
		return suite;
	}

}
