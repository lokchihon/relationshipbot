/*
 * Lok Chi Hon
 */
public class Friend {
	
	public String getGreeting()
	{
		return "Hey best friend!";
	}
	
	public String getResponse (String statement)
	{
		String response = "";
		String [] emotions = {"happy", "excited", "ecstatic", "amazed", "angry", "upset", 
				"salty", "sad", "upset", "depressed", "annoyed", "scared", "overwhelmed", 
				"bitter","confused", "bored", "nervous", "embarrassed", "awkward", "hurt",
				"lonely", "curious"};
		if (statement.length() == 0)
		{
			response = "Are you mad at me? Why aren't you talking about?";
		}
		/* 
		 * Make array of emotions
		 * Make for loop to run through emotions with findKeyword method
		 * Once one of them matches, response = "Why are you " + emotion[i] "?"
		 */
		for (String x : emotions)
		{
			if (emotions[x] == findKeyword(statement, ))
			{
				
			}
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

}
