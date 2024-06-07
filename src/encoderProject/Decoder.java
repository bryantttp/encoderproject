package encoderProject;

import java.util.List;

public class Decoder {
	private char offsetChar;
	private List<Character> refTable;

	// Encapsulation
	public char getOffsetChar() {
		return offsetChar;
	}

	// Encapsulation
	public void setOffsetChar(char offsetChar) {
		this.offsetChar = offsetChar;
	}

	public Decoder(char offsetChar) {
		setOffsetChar(offsetChar);
		ReferenceTable refTableObj = new ReferenceTable();
		refTable = refTableObj.getTable();
	}

	public String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < encodedText.length(); i++) {
			char iteratedChar = encodedText.charAt(i);
			if (refTable.contains(iteratedChar)) {
				int index = refTable.indexOf(iteratedChar);
				int decodedIndex = index + refTable.indexOf(offsetChar);
				if (decodedIndex > 43) {
					decodedIndex -= 44;
				}
				sb.append(refTable.get(decodedIndex));
			} else {
				sb.append(iteratedChar);
			}
		}
		String decodedText = sb.toString();
		return decodedText;
	}

}
