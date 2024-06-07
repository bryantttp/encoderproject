package encoderProject;

public class Runner {
	public static void main(String[] args) {
		// Test cases
		Encoder encoder1 = new Encoder('B');
		Decoder decoder1 = new Decoder('B');
		Encoder encoder2 = new Encoder('F');
		Decoder decoder2 = new Decoder('F');
		String plainText = "HELLO WORLD";
		String encodedText1 = encoder1.encode(plainText);
		System.out.println(encodedText1);
		String decodedText1 = decoder1.decode(encodedText1);
		System.out.println(decodedText1);
		String encodedText2 = encoder2.encode(plainText);
		System.out.println(encodedText2);
		String decodedText2 = decoder2.decode(encodedText2);
		System.out.println(decodedText2);
	}
}
