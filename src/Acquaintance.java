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
		else if (findKeyword(statement, "hey") >= 0)
		{
			response = maggieF.getResponse(statement);
		}
		else if (findKeyword(statement, "hi") >= 0)
		{
			response = maggieL.getResponse(statement);
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
		else if (findKeyword(statement, "February") >= 0
				|| findKeyword(statement, "January") >= 0
				|| findKeyword(statement, "December") >= 0
				|| findKeyword(statement, "Winter") >= 0)
		{
			response = "Winter is my least favorite season! The cold irritates my skin.";
		}
		else if (findKeyword(statement, "April") >= 0
				|| findKeyword(statement, "May") >= 0
				|| findKeyword(statement, "Spring") >= 0
				|| findKeyword(statement, "March") >= 0)
		{
			response = "Rain sucks so I hate spring.";
		}
		else if (findKeyword(statement, "June") >= 0
				|| findKeyword(statement, "July") >= 0
				|| findKeyword(statement, "August") >= 0
				|| findKeyword(statement, "Summer") >= 0)
		{
			
			response = "I love summer! My skin glows so much. Whats your favorite season?";
		}
		else if (findKeyword(statement, "September") >= 0
				|| findKeyword(statement, "October") >= 0
				|| findKeyword(statement, "November") >= 0
				|| findKeyword(statement, "Autumn") >= 0
				|| findKeyword(statement, "Fall") >= 0)
		{
			response = "Autumn is the best becuase of Halloween. What did you go as last year?";
		}
		else if (findKeyword(statement, "supreme") >= 0)
		{
			response = "Forreal?!?! 'Preme Team!!!";
		}
		else if (findKeyword(statement, "Adidas") >= 0
				|| findKeyword(statement, "Nike") >= 0
				|| findKeyword(statement, "Vans") >= 0
				|| findKeyword(statement, "Converse") >= 0
				|| findKeyword(statement, "Supreme") >= 0
				|| findKeyword(statement, "Aero") >= 0
				|| findKeyword(statement, "Forever 21") >= 0
				|| findKeyword(statement, "Gap") >= 0
				|| findKeyword(statement, "Tommy") >= 0
				|| findKeyword(statement, "Polo") >= 0
				|| findKeyword(statement, "Bape") >= 0
				|| findKeyword(statement, "H&M") >= 0)
		{
			response = "Wow, you have great style!";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want", 0) >= 0)
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
					response = getRandomQuestion();
				}
			}
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
	private int findKeyword(String statement, String goal)
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
	
	private String getRandomQuestion ()
	{
		Random r = new Random ();
		return randomRomanticQuestions [r.nextInt(randomRomanticQuestions.length)];
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
			"I see. Are you close to your parents?",
			"Oh. What grade are you in?",
			"Really. What month is your birthday in?",
			"Tight. Do you like to dance.",
			"That's dope. Do you go to school around here?",
			"Oh yeah? Do you have a lot of friends?",
			"That's cool. Do you watch TV a lot?",
			"Sweet. I really like your outfit. What brands do you like to wear?",
			"You look tired. How late did you sleep last night?",
			"Are you a hypebeast, too?"
	};
	
	private String [] randomRomanticQuestions = {
			"Are you single?",
			"Are you looking for a significant other?",
			"Do you think I'm cute?",
			"Do you think my hair looks good?",
			"Do you want to date me?"
	};
	
	public static void main(String[] args)
	{
		Friend maggieF = new Friend();
		Lover maggieL = new Lover();
	}
}