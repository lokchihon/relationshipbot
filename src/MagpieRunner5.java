import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner5
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Acquaintance maggieA = new Acquaintance(); 					//create object for Acquaintance
		Friend maggieF = new Friend(); 								//create object for Friend
		Lover maggieL = new Lover(); 								//create object for Lover
		
		int counterA = 0;
		
		System.out.println (maggieA.getGreeting()); 				//print greeting
		Scanner in = new Scanner (System.in); 						//accept user response
		String statement = in.nextLine().toLowerCase(); 			//store case insensitive user response
			
		while (counterA < 10) 										//while statement doesn't equal "bye" OR less that 10 acquaintance dialogues
		{
			System.out.println (maggieA.getResponse(statement)); 	//print programmed response
			counterA++;												//add 1 to acquaintance dialogue counter
			statement = in.nextLine().toLowerCase(); 				//store case insensitive user response
		}
		
		System.out.println (maggieA.getRomanticResponse(statement)); //instigate romantic dialogue
		statement = in.nextLine().toLowerCase();					//store case insensitive user response
		
		if (maggieA.findKeyword(statement, "yes") >= 0
				|| maggieA.findKeyword(statement, "okay") >= 0
				|| maggieA.findKeyword(statement, "sure") >= 0
				|| maggieA.findKeyword(statement, "yea") >= 0
				|| maggieA.findKeyword(statement, "totally") >= 0
				|| maggieA.findKeyword(statement, "i do ") >= 0
				|| maggieA.findKeyword(statement, "bet") >= 0)
		{
			//enter lover mode
			while (!statement.equals("bye")) 							//while statement doesn't equal "bye"
			{
				System.out.println (maggieL.getResponse(statement)); 	//print programmed response
				statement = in.nextLine().toLowerCase(); 				//store case insensitive user response
			}
		}
		else
		{
			System.out.println ("Oh, okay. " + maggieF.getResponse(statement)); 	//print programmed response
			statement = in.nextLine().toLowerCase(); 					//store case insensitive user response
			
			//enter friend mode
			while (!statement.equals("bye")) 							//while statement doesn't equal "bye"
			{
				System.out.println (maggieF.getResponse(statement)); 	//print programmed response
				statement = in.nextLine().toLowerCase(); 				//store case insensitive user response
			}
		}
	}

}
