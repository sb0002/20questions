import java.util.Scanner;

public class Manager {
	
	public Tree play(Tree fir, Scanner sc) {
		char c='b';
		while(fir.root.isQ) {																//keep looping until an answer is reached
			if(fir.root==null) break;														//tree is empty, nothing to play with
			
			System.out.println(fir.root.data);												//print out the question
			c=sc.next().charAt(0);
			
			if(c=='y' || c=='Y') {															//got an affirmative response
				fir=fir.root.left;
			}
			if(c=='n' || c=='N') {
				fir=fir.root.right;
			}
		}
		System.out.println("All right, you must be thinking of one of them " + fir.root.data + " things. Am I right?");
		
		c=sc.next().charAt(0);																//get the user's response
		String pt="the variable pt is the whatever the player's thinking of, which we don't know yet.";
		String newQ="newQ is the new question the player will be providing";
		if(c=='y' || c=='Y') {																//user acknowledges the computer has read their mind
			System.out.println("I knew it all along.");
		}
		if(c=='n' || c=='N') {																//the user has thought of something not in the database, or they're just hitting no every time.
			sc.nextLine();																	//advance the scanner
			System.out.println("You've stumped me. What were you thinking of?");
			pt=sc.nextLine();																//pt=what the player was thinking of
			System.out.println("Well, give me a question for which 'yes' means " + pt + " and 'no' means " + fir.root.data + " so I can win next time.");
			newQ=sc.nextLine();																//newQ will take the place of the current node as a new question to differentiate between the previous answer and the new one.
			System.out.println("Thanks for making me smarter!");
			
			Tree temp=null;
			
			temp=fir;																		//store the root in temp
			fir.root.right=new Tree();														//make a new subtree for the root to occupy
			fir.root.right.root=new Node(temp.root.data, false);							//put a single node in the tree containing the old answer that the computer thought the user was thinking of
			
			fir.root.left=new Tree();														//make a new left subtree
			fir.root.left.root=new Node(pt, false);											//put in a single node containing what the user was thinking of, and specify that it's an answer.
			
			fir.root.data=newQ;																//replace the root with the new question submitted by the user.
			fir.root.isQ=true;																//make sure the tree knows this is a question
		}
		return fir;																			//send the tree back to main.
	}
}