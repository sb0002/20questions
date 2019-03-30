import java.io.PrintWriter;

public class Util {/*
	 * The makeStr function handles converting Answer and Question flag and string combos into bigger strings
	 * to be written to the q/a file. When this file came into being it seemed like a good idea to put toString here.
	 */
	public void makeStr(Tree t, PrintWriter pw) {
		String temp="my t key doesn't work.";
		if(t.root.isQ) {										//check if the node being looked at contains a question
			temp="Q:\n"+t.root.data+"\n";						//Assemble a Q: question combo to be written to file
			pw.print(temp);										//write to file.
		}
		if(!t.root.isQ) {										//the next line is an answer. assemble and write to file just like a question
			temp="A:\n"+t.root.data+"\n";
			pw.print(temp);
		}
		
		if(t.root.left!=null) makeStr(t.root.left, pw);			//these two lines check to see if it's safe to continue, then run makrStr on the subtree if so.
		if(t.root.right!=null) makeStr(t.root.right, pw);
	}
}