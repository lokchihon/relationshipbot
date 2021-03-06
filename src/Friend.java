/*
 * Lok Chi Hon
 * Aminata Dieng
 * Shannon Zheng
 * Friend class for chatbot
 * Mr. Levin
 * Computer Science A
 */
import java.util.Random;

public class Friend {
	
	public String getGreeting()
	{
		return "Hey best friend! What's gucci?";
	}
	
	private String getRandomGreeting()
	{
		Random r = new Random ();
		return randomGreeting [r.nextInt(randomGreeting.length)];
	}
	
	private String [] randomGreeting = {
			"How was your day?",
			"Hello!",
			"What's up?",
			"Any gossip?"};
	
	public String getResponse (String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Are you mad at me? Why aren't you talking to me?";
		}
		else if (findKeyword(statement, "I am", 0) >= 0
				|| findKeyword(statement, "I'm", 0) >= 0)
		{
			response = transformIAm(statement);
		}
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want", 0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (statement.substring(statement.length()-2, statement.length()-1) == "?")
		{
			response = transformQuestions(statement);
		}
		else if (findKeyword(statement, "hangout", 0) >= 0
				|| findKeyword(statement, "hang out",0) >=0)
		{
			response = createEvent(statement);
		}
		else if (findKeyword (statement, "mother", 0) >= 0
				|| findKeyword (statement, "mom", 0) >= 0
				|| findKeyword (statement, "father", 0) >= 0
				|| findKeyword (statement, "dad", 0) >= 0
				|| findKeyword (statement, "grandmother", 0) >= 0
				|| findKeyword (statement, "grandma", 0) >= 0
				|| findKeyword (statement, "grandfather", 0) >= 0
				|| findKeyword (statement, "grandpa", 0) >= 0
				|| findKeyword (statement, "aunt", 0) >= 0
				|| findKeyword (statement, "uncle", 0) >= 0
				|| findKeyword (statement, "cousin", 0) >= 0
				|| findKeyword (statement, "brother", 0) >= 0
				|| findKeyword (statement, "sister", 0) >= 0
				|| findKeyword (statement, "sibling", 0) >= 0
				)
		{
			response = getFamilyResponses();
		}
		else if (findKeyword (statement, "school", 0) >= 0
				|| findKeyword (statement, "college", 0) >= 0
				|| findKeyword (statement, "university", 0) >= 0
				|| findKeyword (statement, "homework", 0) >= 0
				|| findKeyword (statement, "teacher", 0) >= 0
				|| findKeyword (statement, "class", 0) >= 0
				|| findKeyword (statement, "student", 0) >= 0
				|| findKeyword (statement, "classwork", 0) >= 0
				|| findKeyword (statement, "lesson", 0) >= 0
				|| findKeyword (statement, "test", 0) >= 0
				|| findKeyword (statement, "grades", 0) >= 0
				|| findKeyword (statement, "report cards", 0) >= 0
				)
		{
			response = getSchoolResponses();
		}
		else
		{
			response = getRandomResponse();
		}		
		return response; 
	}
	
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
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	
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
		return "Why don't you " + restOfStatement + " then?";
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
		return "I want " + restOfStatement + "too!";
	}
	
	//Takes user's questions and responds with random responses while prompting the user with more questions
	private String transformQuestions (String statement)
	{
		return "I don't really want to talk about it. What about you?";
	}

	//Transforms "I am ____" statements so the user will be prompted to talk about why they are _____
	private String transformIAm (String statement)
	{
		String response = "";
		if (findKeyword(statement, "happy", 0) >= 0
				|| findKeyword(statement, "glad", 0) >= 0
				|| findKeyword (statement, "giddy", 0) >= 0
				|| findKeyword (statement, "good mood", 0) >= 0
				|| findKeyword (statement, "excited", 0) >= 0
				|| findKeyword (statement, "hyped", 0) >= 0)
		{
			response = "Ooo! What happened? Why are you in a good mood?";
		}

		else if (findKeyword(statement, "sad", 0) >= 0
				|| findKeyword(statement, "upset", 0) >= 0
				|| findKeyword (statement, "angry", 0) >= 0
				|| findKeyword (statement, "bad mood", 0) >= 0
				|| findKeyword (statement, "depressed", 0) >= 0
				|| findKeyword (statement, "annoyed", 0) >= 0)
		{
			response = "Aw. Why are you in a bad mood? You know you can always talk to me right?";
		}
		else
			{
				response = "Why? Tell me about it.";
			}
		return response;
	}
	
	private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}
	
	private String getSchoolResponses()
	{
		Random r2 = new Random();
		return schoolResponses [r2.nextInt(schoolResponses.length)];
	}
	
	private String getFamilyResponses ()
	{
		Random r3 = new Random();
		return familyResponses[r3.nextInt(familyResponses.length)];
	}
	
	private String createEvent(String statement)
	{
		Random r4 = new Random();
		return eventResponses [r4.nextInt(eventResponses.length)];
	}
	
	//Generates non-commital responses
	private String [] randomResponses = {
			"Interesting, tell me more",
			"No way.",
			"Are you sure?",
			"You don't say.",
			//  All you need to do is add lines here
			"When can we hang out?",
			"Are you free any time soon?",
			"How's life?",
			"What are you up to?",
			"Anything interesting going on in your life?",
			};
	
	//Generates responses in regards of school
	private String [] schoolResponses= {
			"I had a pretty bad day at school today. How was your day?",
			"I stayed up all night doing a project. Have you had any projects lately?",
			"My teacher assigned a crazy amount of homework. Do your teachers do that?",
			"I have this huge term paper. Do you get term papers?",
			"Report cards are coming out soon! :(",
			"I can't wait to graduate!",
			};
	
	//Generates responses in regards of family
	private String [] familyResponses = {
			"My family is doing good! How's your family?",
			"We had a HUGE family dinner the other day! Did you have any family dinners recently?",
			"Christmas is coming up soon! What's a good gift for any family member?",
			"My aunt keeps bugging me about colleges. What colleges do you want to go to?"
	};
	
	//Generates responses about planning a hangout
	private String [] eventResponses = {
			"Where do you like to hangout?",
			"What's your favorite activity?",
			"I'm so busy lately. Maybe another time!",
			"I'm free Wednesdays."
	};
}


