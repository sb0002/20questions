import java.util.Scanner;

public class Tree {
	Node root=null;
	
	Tree plantTree(Scanner sc) {													//this function handles the construction of a tree by reading from the database file
		Tree shrub=new Tree();														//make a new tree to grow
		if(!sc.hasNext()) return shrub;												//exit if the DB file is empty
		String temp="this string will hold the node's data";
		if(sc.hasNextLine()) temp=sc.nextLine();									//if the DB file has a next line, assign it to the temp string.
        
		if(temp.charAt(0) == 'A') {													//'A' detected in file. the next line must be an answer.
			if(sc.hasNextLine()) temp=sc.nextLine();								//assign answer to temp string.
			shrub.root=new Node(temp, false);										//make a new node to hold the data
			return shrub;															//send the tree back to main
		}
		
		if(temp.charAt(0) == 'Q' && sc.hasNextLine()) temp=sc.nextLine();			//if DB has a next line, and it is a question, assign it to temp.
		Tree yes=plantTree(sc);														//left and right subtrees for Q or A, constructed recursively.
		Tree no=plantTree(sc);
		if(sc.hasNextLine()) temp=sc.nextLine();									//store the question to be stored elsewhere later.
		
		shrub.root=new Node(temp, true);											//create a new node containing the question, and marked as a question
		shrub.root.left=yes;														//set left and right subtrees to subsequent questions or answers, if they exist
		shrub.root.right=no;														
		return shrub;																//send the tree back to main
	}
	
	void nlrt() {
		if(root!=null) root.nlr();
	}
}