import java.util.Random;

public class Acquaintance 
{	
	public String getGreeting() 
	{
		return getRandomGreeting();
	}
	
	//return a random greeting
	private String getRandomGreeting()
	{
		Random r = new Random ();
		return randomGreeting [r.nextInt(randomGreeting.length)];
	}
	
	//list randomized greetings
	private String [] randomGreeting = {
			"Have we met before?",
			"You look like my mom!",
			"Hi, I'm AJ! It's nice to meet you.",
			"Hello!",
			"What's up?",
			"Do you come here often?",
			"Hi, how are you?",
			"You dressed really well."
	};
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "You there?";
		}
		else if (findKeyword(statement, "how are you") >= 0)
		{
			response = "Good, thanks.";
		}
		else if (findKeyword(statement, "yours?") >= 0)
		{
			response = "My what?";
		}
		else if (findKeyword(statement, "You?") >= 0)
		{
			response = "What about me?";
		}
		else if (findKeyword(statement, "manhattan") >= 0)
		{
			response = "I wish I lived in downtown Manhattan; It's in the center of everything!";
		}
		else if (findKeyword(statement, "bronx") >= 0)
		{
			response = "How about we NOT talk about the Bronx?";
		}
		else if (findKeyword(statement, "staten island") >= 0)
		{
			response = "I kinda feel like we should gift Staten Island to New Jersey...";
		}
		else if (findKeyword(statement, "brooklyn") >= 0)
		{
			response = "Word to your timbs?";
		}
		else if (findKeyword(statement, "queens") >= 0)
		{
			response = "I live in Queens, but it gets too quiet sometimes.";
		}
		else if (findKeyword(statement, "your name") >= 0)
		{
			response = "My name's AJ.";
		}
		else if (findKeyword(statement, "fun") >= 0)
		{
			response = "What do you do for fun? Synchronized swimming is fun for me.";
		}
		else if (findKeyword(statement, "swim") >= 0
				|| findKeyword(statement, "run") >= 0
				|| findKeyword(statement, "football") >= 0
				|| findKeyword(statement, "soccer") >= 0
				|| findKeyword(statement, "baseball") >= 0
				|| findKeyword(statement, "badminton") >= 0
				|| findKeyword(statement, "tennis") >= 0
				|| findKeyword(statement, "basketball") >= 0)
		{
			response = "Are you athletic?";
		}
		else if (findKeyword(statement, "sports") >= 0)
		{
			response = "Do you play any sports?";
		}
		else if (findKeyword(statement, "school") >= 0
				||findKeyword(statement, "school") >= 0
				|| findKeyword(statement, "grade") >= 0)
		{
			response = "I'm so anxious to graduate in a few months.";
		}
		else if (findKeyword(statement, "how to get awway with murder") >= 0
				|| findKeyword(statement, "orange is the new black") >= 0
				|| findKeyword(statement, "american horror story") >= 0
				|| findKeyword(statement, "game of thrones") >= 0
				|| findKeyword(statement, "the walking dead") >= 0
				|| findKeyword(statement, "scandal") >= 0
				|| findKeyword(statement, "svu") >= 0
				|| findKeyword(statement, "scandal") >= 0
				|| findKeyword(statement, "onr tree hill") >= 0
				|| findKeyword(statement, "american horror story") >= 0
				|| findKeyword(statement, "grey's anatomy") >= 0)
		{
			response = "That show seems slow to me. Is it good?";
		}
		else if (findKeyword(statement, "beyonce") >= 0
				|| findKeyword(statement, "drake") >= 0
				|| findKeyword(statement, "bieber") >= 0
				|| findKeyword(statement, "chance") >= 0)
		{
			response = "I love their music!";
		}
		else if (findKeyword(statement, "the 100") >= 0
				|| findKeyword(statement, "the walking dead") >= 0
				|| findKeyword(statement, "scandal") >= 0
				|| findKeyword(statement, "svu") >= 0
				|| findKeyword(statement, "scandal") >= 0
				|| findKeyword(statement, "one tree hill") >= 0
				|| findKeyword(statement, "american horror story") >= 0
				|| findKeyword(statement, "grey's anatomy") >= 0)
		{
			response = "That show seems slow to team.";
		}
		else if (findKeyword(statement, "tv") >= 0
				|| findKeyword(statement, "show") >= 0)
		{
			response = "My favorite show is Law & Order: SVU. I dance to the theme song.";
		}
		else if (findKeyword(statement, "february") >= 0
				|| findKeyword(statement, "january") >= 0
				|| findKeyword(statement, "december") >= 0
				|| findKeyword(statement, "winter") >= 0)
		{
			response = "Winter is my least favorite season! The cold irritates my skin.";
		}
		else if (findKeyword(statement, "april") >= 0
				|| findKeyword(statement, "may") >= 0
				|| findKeyword(statement, "spring") >= 0
				|| findKeyword(statement, "march") >= 0)
		{
			response = "Rain sucks so I hate spring.";
		}
		else if (findKeyword(statement, "june") >= 0
				|| findKeyword(statement, "july") >= 0
				|| findKeyword(statement, "august") >= 0
				|| findKeyword(statement, "summer") >= 0)
		{
			
			response = "I love summer! My skin glows so much. Whats your favorite season?";
		}
		else if (findKeyword(statement, "september") >= 0
				|| findKeyword(statement, "cctober") >= 0
				|| findKeyword(statement, "november") >= 0
				|| findKeyword(statement, "autumn") >= 0
				|| findKeyword(statement, "fall") >= 0)
		{
			response = "Autumn is the best because of Halloween. What did you go as last year?";
		}
		else if (findKeyword(statement, "supreme") >= 0)
		{
			response = "Forreal?!?! 'Preme Team!!!";
		}
		else if (findKeyword(statement, "adidas") >= 0
				|| findKeyword(statement, "nike") >= 0
				|| findKeyword(statement, "vans") >= 0
				|| findKeyword(statement, "converse") >= 0
				|| findKeyword(statement, "supreme") >= 0
				|| findKeyword(statement, "aero") >= 0
				|| findKeyword(statement, "forever ") >= 0
				|| findKeyword(statement, "gap") >= 0
				|| findKeyword(statement, "tommy") >= 0
				|| findKeyword(statement, "polo") >= 0
				|| findKeyword(statement, "bape") >= 0
				|| findKeyword(statement, "shopping") >= 0
				|| findKeyword(statement, "h&m") >= 0)
		{
			response = "Wow, you have great style! We should go shopping together soon.";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Are you close with your family?";
		}
		else if (findKeyword(statement, "thank you") >= 0
				|| findKeyword(statement, "thanks") >= 0
				|| findKeyword(statement, "good looks") >= 0)
		{
			response = "You're welcome!";
		}
		else if (findKeyword(statement, "i want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "i want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else
		{

			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);

			if (psn >= 0
					&& findKeyword(statement, "me", psn) >= 0)
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				//  Part of student solution
				// Look for a two word (I <something> you)
				// pattern
				psn = findKeyword(statement, "i", 0);

				if (psn >= 0
						&& findKeyword(statement, "you", psn) >= 0)
				{
					response = transformIYouStatement(statement);
				}
				else
				{
					response = getRandomPlatonicQuestion();
				}
			}
		}
		return response;
	}
	
	public String getRomanticResponse(String statement)
	{
		String response = "";
		response = getRandomRomanticQuestion();
		return response;
	}
	
	public String getWYRQuestion(String statement)
	{
		String response = "";
		response = getRandomWYR();
		return response;
	}
	
	public String getWYRAnswer(String statement)
	{
		String response = "";
		response = transformWYR(statement);
		return response;
	}
	
	public String getWYRResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "You there?";
		}
		else if (findKeyword(statement, "funniest") >= 0)
		{
			response = "I agree because I think I'm doing okay for smarts.";
		}
		else if (findKeyword(statement, "intelligent") >= 0)
		{
			response = "You'd probably find their humor cheap!";
		}
		else if (findKeyword(statement, "beginning") >= 0)
		{
			response = "What about me?";
		}
		else if (findKeyword(statement, "end") >= 0)
		{
			response = "Sounds dark. Cool!";
		}
		else if (findKeyword(statement, "continue") >= 0)
		{
			response = "You've made it this far, right?";
		}
		else if (findKeyword(statement, "restart") >= 0)
		{
			response = "I'd do anything for a clean slate too!";
		}
		else if (findKeyword(statement, "space") >= 0)
		{
			response = "It must get so lonely and cold up there!";
		}
		else if (findKeyword(statement, "sea") >= 0)
		{
			response = "Those deep sea fish with lightbulb eyes are kinda creepy.";
		}
		else if (findKeyword(statement, "cold") >= 0)
		{
			response = "I guess you could always wear a lot of clothes to ward it off.";
		}
		else if (findKeyword(statement, "hot") >= 0)
		{
			response = "Same! I like to sweat.";
		}
		else if (findKeyword(statement, "forwards") >= 0)
		{
			response = "Tell me about the flying cars!";
		}
		else if (findKeyword(statement, "backwards") >= 0)
		{
			response = "Let me know if Cleopatra was as hot as everyone hyped her up to be.";
		}
		else if (findKeyword(statement, "ugly") >= 0
				|| findKeyword(statement, "genius") >= 0)
		{
			response = "You can create a hottie elixer. Clever!";
		}
		else if (findKeyword(statement, "moron") >= 0)
		{
			response = "Conceited much?";
		}
		
		return response;
	}
	
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		
		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "rather" followed by "or"
	 * @return the transformed statement
	 */
	private String transformWYR(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfRather = findKeyword (statement, "rather", 0);
		int psnOfOr = findKeyword (statement, "or", psnOfRather);
		
		String choice1 = statement.substring(psnOfRather + 1, psnOfOr).trim();
		String choice2 = statement.substring(psnOfRather + 1, psnOfOr).trim();
		return "I'd r" + choice1 + ". " + getRandomAffirmations();
	}
	

	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	public int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}
	private String getRandomAffirmations ()
	{
		Random r = new Random ();
		return affirmations [r.nextInt(affirmations.length)];
	}
	
	private String getRandomPlatonicQuestion ()
	{
		Random r = new Random ();
		return randomPlatonicQuestions [r.nextInt(randomPlatonicQuestions.length)];
	}
	
	private String getRandomRomanticQuestion ()
	{
		Random r = new Random ();
		return randomRomanticQuestions [r.nextInt(randomRomanticQuestions.length)];
	}
	
	private String getRandomWYR ()
	{
		Random r = new Random ();
		return wouldYouRathers [r.nextInt(wouldYouRathers.length)];
	}
	
	private String [] randomResponses = {
			"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"Gee wilikers",
			"Is it getting hot in here?",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	
	private String [] randomPlatonicQuestions = {
			"Nice. Do you like sports?",
			"I see. Are you the oldest sibling?",
			"Oh. What grade are you in?",
			"Really. What month is your birthday in?",
			"That's pretty tight!",
			"Anyway, what school do you go to?",
			"That's dope. Do you go to school around here?",
			"Oh yeah? Do you have a lot of friends?",
			"That's cool. What shows have you been watching?",
			"Sweet. I really like your outfit. What brands do you like to wear?",
			"You look tired. How late did you sleep last night?",
			"Are you a hypebeast, too?"
	};
	
	private String [] randomRomanticQuestions = {
			"Are you single?",
			"Are you looking for a significant other?",
			"Do you think I'm cute?",
			"Do you think my hair looks good?",
			"Would you want to date me?"
	};
	
	private String [] wouldYouRathers = {
			"Would you rather be the funniest person in the room or most intelligent?",
			"Would you rather experience the beginning of planet Earth or the end?",
			"Would you rather continue with life or restart it?",
			"Would you rather live in space or under the sea?",
			"Would you rather be super cold or super hot?",
			"Would you rather have a time machine that goes only forwards or only backwards?",
			"Would you rather be an ugly genius or a hot moron?"
	};
	
	private String [] affirmations = {
			"Who'd do the other one?",
			"Yeah, definitely!",
			"That's the better of the two.",
			"That was a toughie.",
			"That's easy.",
			"Actually, I don't know.",
			"Good one!"
	};
}