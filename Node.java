public class Node {
	String data;										//data string; can be an answer or a question
	boolean isQ;										//tells whether the data is Q or A; if true, data is a question
	Tree left=null;										//left and right subtrees
	Tree right=null;
	
	public Node(String bleh, boolean bool) {			//create a new node containing a question or answer string, and a flag declaring the data's orientation
		data=bleh;
		isQ=bool;
	}
	
	void nlr() {										//do a node-left-right traversal of the tree.
		System.out.println(data);
		if(left!=null) left.nlrt();
		if(right!=null) right.nlrt();
	}
}