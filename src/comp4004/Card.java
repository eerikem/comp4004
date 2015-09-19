package comp4004;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Card {

	private static final ArrayList<String> numbers = new ArrayList<String>(
			Arrays.asList(null, null, "Two", "Three", "Four", "Five", "Six",
					"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King",
					"Ace"));

	private int value;
	private String suite;
	
	public Card(String string) {
		String[] card = StringUtils.splitByCharacterTypeCamelCase(string);
		if (numbers.contains(card[0])){
			this.value = numbers.indexOf(card[0]);
		}
		this.suite = card[1];
			
	}

	public Object getValue() {
		return value;
	}

	public Object getSuite() {
		return suite;
	}

}
