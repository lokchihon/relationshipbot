/*
 * Lok Chi Hon
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
		else if (findKeyword(statement, "I am", 0) >= 0)
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
		else if (statement.substring(statement.length()-1) == "?")
		{
			response = transformQuestions(statement);
		}
		else
		{
			response = getRandomResponse();
		}

		/* 
		 * Make array of emotions
		 * Make for loop to run through emotions with findKeyword method
		 * Once one of them matches, response = "Why are you " + emotion[i] "?"
		
		for (int x = 0; x < emotions.length; x++)
		{
			if (emotions[x] == findKeyword(statement, x))
			{
				response = "Why are you " + emotions[x];
			}
		}
		*/
		
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
		return "Why do you want to " + restOfStatement + "then?";
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
		String response = "";
		for(int i = 0; i<familyMembers.length; i++)
		{
			if (findKeyword(statement, familyMembers[i], 0) >= 0)
			{
				response = getFamilyResponses();
			}
		}
		
		for(int k = 0; k<school.length; k++)
		{
			if (findKeyword(statement, school[k], 0) >= 0)
			{
				response = getSchoolResponses();
			}
			else
				response = "I don't really want to talk about it. What about you?";
		}
		return response;
	}

	
	//Transforms "I am ____" statements so the user will be prompted to talk about why they are _____
	private String transformIAm (String statement)
	{
		String response = "";
		for(int i = 0; i<positiveEmotions.length; i++)
		{
			if (findKeyword(statement, positiveEmotions[i], 0) >= 0)
			{
				response = "Ooo! What happened? Why are you " + positiveEmotions[i] + "?";
			}
		}
		
		for(int k = 0; k<negativeEmotions.length; k++)
		{
			if (findKeyword(statement, positiveEmotions[k], 0) >= 0)
			{
				response= "Aw. Why are you " + negativeEmotions[k] + "? You know you can always talk to me right?";
			}
			else
			{
				response = "Why? Tell me about it.";
			}
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
	
	//Generates non-commital responses
	private String [] randomResponses = {
			"Interesting, tell me more",
			"No way.",
			"Are you sure?",
			"You don't say.",
			//  All you need to do is add lines here
			"When can we hang out?"
			};
	
	//Generates responses in regards of school
	private String [] schoolResponses= {
			"I had a pretty bad day at school today. How was your day?",
			"I stayed up all night doing a project. Have you had any projects lately?",
			"My teacher assigned a crazy amount of homework. Do your teachers do that?",
			"I have this huge term paper. Do you get term papers?"
			};
	
	//Generates responses in regards of family
	private String [] familyResponses = {
			"My family is doing good! How's your family?",
			"We had a HUGE family dinner the other day! Did you have any family dinners recently?",
			"Christmas is coming up soon! What's a good gift for any family member?",
	};

	//List of family members
	private String [] familyMembers = {
			"mother", 
			"father", 
			"grandmother",
			"grandmother",
			"uncle",
			"aunt",
			"brother",
			"sister",
	};
	
	//List of school related words
	private String [] school = {
			"school",
			"college",
			"university",
			"homework",
			"teacher",
			"class",
			"classmate",
			"term",
			"semester",
	};
	
	//List of positive emotions
	private String [] positiveEmotions = {
			"happy",
			"giddy",
			"good mood",
			"excited",
			"glad",
			"hyped"
	};
	
	//List of negative emotions
	private String [] negativeEmotions = {
			"sad",
			"depressed",
			"upset",
			"angry",
			"mad",
			"bad mood"
	};
	

	
	
	}


