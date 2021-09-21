import java.util.ArrayList;
import java.util.Scanner;

public class FunWithStrings {

	public static void main (String[] args) {

		System.out.println("Enter some text:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println("You typed: " + input);
		int chars = input.length();
		System.out.println("which has " + chars + " characters in it.");
		String[] words = input.split(" ");
		int wordCount = words.length;
		System.out.println("There are " + wordCount + " words in it.");
		
		for (int i = 0; i < words.length; i++) {
			// if (i == 2) {
			// 	 words[i] = "EXPLOSION";
			// }
			if (i == 0) {
				System.out.println("The first word is " + words[i]);
			} else {
				System.out.println("The next word is " + words[i]);
			}
		}

		// BONUS TOPIC: fun with ArrayList
		// ArrayList is slightly slower than an array, but it can grow and shrink
		// you also must use methods they don't have [] notation

		ArrayList<String> cosmere = new ArrayList<String>();
		cosmere.add("Way of Kings");
		cosmere.add("Words of Radiance");
		cosmere.add("Oathbringer");
		cosmere.add("Rhythm of War");
		cosmere.add("Elantris");
		cosmere.add("Warbreaker");
		cosmere.add("Final Empire");
		cosmere.add("Well of Ascension");
		cosmere.add("Hero of Ages");

		for (String a : cosmere) {
			System.out.println(a);
		}

		cosmere.add("Alloy of Law");
		cosmere.add("Shadows of Self");
		cosmere.add("Bands of Mourning");
		cosmere.add("The Lost Metal");

		for (int i = 0; i < cosmere.size(); i++) {
			System.out.println(cosmere.get(i));
		}

		s.close();
		
	}

}