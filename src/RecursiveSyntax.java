/**
 * This program generates random sentences.
 * 
 * Here are some sentences generated after completing the program.
 * 
 * 		the laptop who runs sees Fred because a laptop who knows every man who loves the unicorn sleeps
 * 
 * 		some man believes that the elephant who loves Jane talks but a laptop jumps 
 * 
 * 		the elephant who looks for Miss America sees a unicorn who jumps or Fred runs but the elephant is tiny
 * 
 * 		a vibrant unicorn knows a woman who runs and every pretty laptop sleeps because Jane finds the big chair 
 * 
 * 		some unicorn who hates Michelle is tiny or Fred talks because some pretty chair who hates the unicorn who knows every bald unicorn believes that Fred sleeps
 * 
 * 		Jane moves but every man who finds Richard Nixon is tiny but Jane moves 
 * 
 * 		some chair hates the fish who finds Richard Nixon and Miss America believes that the unicorn who jumps hates the bald woman who is vibrant
 * 
 */

/**
 * 
 * 
 * @author Anonymous UOPeople Student
 *
 */
public class RecursiveSyntax {
	
	// Initialize list of conjunctions
	static final String[] conjunctions = {"and", "or", "but", "because"};
	
	// Initialize list of proper nouns
	static final String[] properNouns = {"Dean C", "Fred", "Jane", "Richard Nixon", "Miss America", "Michelle"};
	
	// Initialize list of common nouns
	static final String[] commonNouns = {"man", "woman", "fish", "elephant", "unicorn", "chair", "laptop"};
	
	// Initialize list of determiners
	static final String[] determiners = {"a", "the", "every", "some"};
	
	// Initialize list of adjectives
	static final String[] adjectives = {"big", "tiny", "pretty", "bald", "vibrant"};
	
	// Initialize list of intransitive verbs
	static final String[] intransitiveVerbs = {"runs", "jumps", "talks", "sleeps", "moves"};
	
	// Initialize list of transitive verbs
	static final String[] transitiveVerbs = {"loves", "hates", "sees", "knows", "looks for", "finds"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Call to start creating sentence
		sentence();
	}
	
	/**
	 * Rule to create a sentence
	 * 
	 */
	static void sentence() {
		simpleSentence();
		
		if (Math.random() > 0.35) {
			System.out.print(randomItem(conjunctions) + " ");
			sentence();
		}
	}
	
	/**
	 * Rule to create a simple sentence
	 * 
	 */
	static void simpleSentence() {
		nounPhrase();
		verbPhrase();
	}
	
	/**
	 * Rule to create a noun phrase
	 * 
	 */
	static void nounPhrase() {
		if (Math.random() > 0.55) {
			System.out.print(randomItem(properNouns) + " ");
		} else {
			System.out.print(randomItem(determiners) + " ");
			if (Math.random() < 0.36) {
				System.out.print(randomItem(adjectives) + " ");
			}
			System.out.print(randomItem(commonNouns) + " ");
			if (Math.random() > 0.42) {
				System.out.print("who ");
				verbPhrase();
			}
		}
	}
	
	/**
	 * Rule to create a verb phrase
	 * 
	 */
	static void verbPhrase() {
		int randVal = (int)(Math.random() * 12);
		
		if (randVal <= 2) {
			System.out.print(randomItem(intransitiveVerbs) + " ");
		} else if (randVal > 2 && randVal < 6) {
			System.out.print(randomItem(transitiveVerbs) + " ");
			nounPhrase();
		} else if (randVal > 5 && randVal < 9) {
			System.out.print("is " + randomItem(adjectives) + " ");
		} else {
			System.out.print("believes that ");
			simpleSentence();
		}
	}
	
	/**
	 * Method for picking a random item from an array of strings
	 * @params array
	 */
	static String randomItem(String[] listOfStrings) {
		int index = (int)(Math.random()*listOfStrings.length);
		return listOfStrings[index];
	}

}
