import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Tree fir=new Tree();												//if it's gonna be a tree, we might as well be specific, right?
		Util util=new Util();												//make new container for makestring function
		Manager boss=new Manager();											//make new gameplay manager	
		
		//replace with /path/to/databasefile.txt
		String database="/home/bob/eclipse-workspace/PA4-2/src/qs.txt";		//make a database shortcut
		File dataFile = new File(database);
        Scanner sc;
        try {																//initialize a database reader, and exit if unable to do so.
        	sc = new Scanner(dataFile);
        } catch(Exception e) {
        	System.out.println("Input error: " + e);
        	return;
        }
        
        Scanner sc2=new Scanner(System.in);									//this scanner exists to get input from the user
		fir=fir.plantTree(sc);												//"construct" the tree
		//fir.nlrt();														//optional node-left-right tree traversal with printout

		
		System.out.println("Welcome to Twenty or More questions! I'll be guessing what you're thinking of, whether you like it or not. Let's get started.");
		boss.play(fir, sc2);												//master gameplay controller
		
		PrintWriter scribe;
        try {																//attempt to initialize a file writer, and exit if unable to do so.
        	scribe=new PrintWriter((new BufferedWriter(new FileWriter(database))));
        } catch(Exception e) {
        	System.out.println("Write error: " + e);
        	sc2.close();
        	return;
        }
		util.makeStr(fir, scribe);											//make node and flag combos into strings, and write them to file.
		
		scribe.close();														//close all the scanners
		sc2.close();
		sc.close();
	}
}