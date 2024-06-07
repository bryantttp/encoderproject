package encoderProject;

import java.util.List;

public class Encoder {
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

	public Encoder(char offsetChar) {
		setOffsetChar(offsetChar);
		ReferenceTable refTableObj = new ReferenceTable();
		refTable = refTableObj.getTable();
	}

	public String encode(String plainText) {
		StringBuilder sb = new StringBuilder();
		sb.append(offsetChar);
		for (int i = 0; i < plainText.length(); i++) {
			char iteratedChar = plainText.charAt(i);
			if (refTable.contains(iteratedChar)) {
				int index = refTable.indexOf(iteratedChar);
				int encodedIndex = index - refTable.indexOf(offsetChar);
				if (encodedIndex < 0) {
					encodedIndex += 44;
				}
				sb.append(refTable.get(encodedIndex));
			} else {
				sb.append(iteratedChar);
			}
		}
		String encodedText = sb.toString();
		return encodedText;
	}
}
