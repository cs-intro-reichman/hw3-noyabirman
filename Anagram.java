/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String new1= preProcess(str1);
		String new2= preProcess(str2);

		if (new1.length() != new2.length()) {
            return false;
		}

		for (int i=0; i<new1.length();i++){
			boolean identical= false;
			for (int j=0; j<new2.length();j++){
				if (new1.charAt(i)==new2.charAt(j)){
				new2=new2.substring(0,j)+new2.substring(j+1);
				identical= true;
				break;

			}
		}
		if (!identical){
			return false;
		}
	}
	return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String pre= "";
		for (int i=0; i<str.length();i++){
			if (Character.isLetter(str.charAt(i))){
				pre+=Character.toLowerCase(str.charAt(i));
			}
		}
		return pre;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomAnagram="";
		String processed= preProcess(str);
		
		while (processed.length() > 0) {
				int randomIndex= (int)(Math.random()* processed.length());
				randomAnagram+=processed.charAt(randomIndex);
				processed = processed.substring(0, randomIndex) + processed.substring(randomIndex + 1);
			} 
			return randomAnagram;
		}
	}

