import java.util.Random;

/*
Shannon Zheng
Aminata Dieng
Lok Chi Hon

Lover class for relationshipbot
*/
public class Lover
{
	public String getGreeting()
		{
			return "Hey babe!";
		}

	public String getResponse(String statement)
		{
			String response = "";
			if (statement.length() == 0)
			{
				response = "babe?";
			}
			else if (findKeyword(statement, "bad") >= 0
					|| findKeyword(statement, "terrible") >= 0
					|| findKeyword(statement, "hated it") >= 0)
			{
				response = "Why? ";
			}
			else if (findKeyword(statement, "good") >= 0
					|| findKeyword(statement, "amazing") >= 0
					|| findKeyword(statement, "awesome") >= 0)
			{
				response = "Really? Tell me all about it!";
			}
			else if (findKeyword(statement, "I love you") >= 0)
			{
				response = "I love you too. ";
			}
			else if (findKeyword(statement, "mother") >= 0
					|| findKeyword(statement, "father") >= 0
					|| findKeyword(statement, "sister") >= 0
					|| findKeyword(statement, "brother") >= 0)
			{
				response = "Speaking of family, my parents misses"
						+ " you and wants you to come over for dinner.";
			}
			else if (findKeyword(statement, "on a date") >= 0)
			{
				response = "Lets go on a date next week";
			}
			else if (findKeyword(statement, "I want to", 0) >= 0)
			{
				response = transformIWantToStatement(statement)
						+ "Lets do that for our date.";
			}
			else if (findKeyword(statement, "I want", 0) >= 0)
			{
				response = transformIWantStatement(statement);
			}
			else if (findKeyword(statement, "to go on", 0) >= 0
					|| findKeyword(statement, "to go to", 0) >= 0
					|| findKeyword(statement, "hang out at", 0) >= 0
					|| findKeyword(statement, "to go in", 0) >= 0)
			{
				response = transformToGoStatement(statement);
			}
			else if (findKeyword(statement, "I love you too", 0) >= 0)
			{
				response = "I love you three";
			}
			else if (findKeyword(statement, "I love you four", 0) >= 0)
			{
				response = "I love you five";
			}
			else if (findKeyword(statement, "I love you six", 0) >= 0)
			{
				response = "we both know i love you more <3";
			}
			else
			{
				int psn = findKeyword(statement, "you", 0);

				if (psn >= 0
			&& findKeyword(statement, "me", psn) >= 0)
				{
					response = transformYouMeStatement(statement);
				}
				else
				{
					psn = findKeyword(statement, "I", 0);

					if (psn >= 0
							&& findKeyword(statement, "you", psn) >= 0)
					{
						response = transformIYouStatement(statement);
					}
					else
					{
						response = getRandomResponse();
					}
				}	
			}
			return response;
		}

	private String transformIWantToStatement(String statement)
	{
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
		return "Me too" + "!" + "Lets " + restOfStatement + "!";
	}

	private String transformIWantStatement(String statement)
	{
		// Remove the final period, if there is one
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
		return "Do you really want to " + restOfStatement + "?";
	}

	private String transformYouMeStatement(String statement)
	{
		// Remove the final period, if there is one
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
		return "Babe, what would make you think that I would" 
		+ restOfStatement + " you?";
	}

	private String transformIYouStatement(String statement)
	{
		// Remove the final period, if there is one
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

	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}

	private String [] randomResponses =
{
		"It's ok, I still love you",
		"Can you say that again, Honey?",
		"Do you really think so?",
		"Mom and dad are making fried chicken tonight. Come over",
		"Oh really?",
		"Do you want to go on a date this weekend?",
		"So, would you like to go see a movie?",
		"I love you",
		"<3 <3 <3"
	};
	private String transformToGoStatement(String statement)
	{
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
			{
			statement = statement.substring(0, statement
					.length() - 1);
			}

		int psn = findKeyword (statement, "to go", 0);
 
 
		String restOfStatement = statement.substring(psn + 5).trim();
		return "Sure, lets" + restOfStatement + " together?";
	}

	}