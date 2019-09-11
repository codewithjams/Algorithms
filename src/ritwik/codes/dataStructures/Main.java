package ritwik.codes.dataStructures;

import ritwik.codes.dataStructures.linkedList.LinkedList;
import ritwik.codes.dataStructures.queues.ArrayQueue;
import ritwik.codes.dataStructures.queues.LinkedListQueue;
import ritwik.codes.dataStructures.stack.ArrayStack;
import ritwik.codes.dataStructures.stack.LinkedListStack;
import ritwik.codes.dataStructures.stack.ReverseString;

import java.util.Scanner;

public class Main {
	private Scanner mScanner;

	private Main () {
		initialize ();
	}

	public static void main ( String [] args ) {
		Main main = new Main ();

		switch ( main.inputDataStructure () ) {
			case 1 : {
				main.useLinkedList ();
			} break;

			case 2 : {
				main.useStack ();
			} break;

			case 3 : {
				main.useQueue ();
			} break;

			default : {
				main.printLineConsoleOutput ( "Wrong Choice Entered" );
			}
		}
	}

	private void initialize () {
		mScanner = new Scanner ( System.in );
	}

	private int inputDataStructure () {
		printConsoleOutput ( "1. Linked List\n2. Stack\n3. Queue\nEnter your choice : " );
		return mScanner.nextInt ();
	}

	private String inputText () {
		printConsoleOutput ( "Enter a String to reverse : " );
		return mScanner.next ();
	}

	private void useLinkedList () {
		LinkedList list = new LinkedList ();
		printLineConsoleOutput ( "Is the List empty : " + list.isEmpty () );

		printConsoleOutput ( "---------- ADD ITEMS ONE BY ONE ----------\n" );
		printLineConsoleOutput ( "Size of List : " + list.getSize () );
		list.insert ( 1 );
		list.insert ( 2 );
		list.insert ( 3 );
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		printConsoleOutput ( "---------- INSERT ITEM AT POSITION 1 ----------\n" );
		list.insert ( 4, 1 );
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		printConsoleOutput ( "---------- DELETE ITEM AT POSITION 2 ----------\n" );
		list.delete ( 2 );
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		printConsoleOutput ( "------------ REVERSING A LIST --------------\n" );
		list.reverse ();
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		printConsoleOutput ( "---------- DELETE ITEMS ONE BY ONE ----------\n" );
		list.delete ();
		list.delete ();
		list.delete ();
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		printConsoleOutput ( "---------- ADD ITEMS ONE BY ONE ----------\n" );
		list.insert ( 1 );
		list.insert ( 2 );
		list.insert ( 3 );
		printLineConsoleOutput ( "Content of List : " + list.toString () + "\tSize : " + list.getSize () );

		/*printLineConsoleOutput ( "Element at Index 1 : " + list.get ( 1 ) );
		printLineConsoleOutput ( "Element at Index 1 : " + list.get ( 2 ) );
		printLineConsoleOutput ( "Element at Index 1 : " + list.get ( 3 ) );*/
	}

	private void useStack () {
		printLineConsoleOutput ( "STACK USING ARRAY -------------------------" );
		ArrayStack arrayStack = new ArrayStack ();
		printLineConsoleOutput ( "Is Stack Empty : " + arrayStack.isEmpty () );
		arrayStack.push ( 1 );
		printLineConsoleOutput ( "Is Stack Empty : " + arrayStack.isEmpty () );
		printLineConsoleOutput ( "Content of Stack : " + arrayStack.toString () );
		arrayStack.push ( 2 );
		arrayStack.push ( 3 );
		printLineConsoleOutput ( "Content of Stack : " + arrayStack.toString () );
		printLineConsoleOutput ( "Top Most Element in Stack : " + ( arrayStack.top () == ArrayStack.INVALID_VALUE ? "Invalid Value" : arrayStack.top () ) );
		arrayStack.pop ();
		printLineConsoleOutput ( "Content of Stack : " + arrayStack.toString () );
		arrayStack.pop ();
		arrayStack.pop ();
		printLineConsoleOutput ( "Top Most Element in Stack : " + ( arrayStack.top () == ArrayStack.INVALID_VALUE ? "Invalid Value" : arrayStack.top () ) );

		printLineConsoleOutput ( "STACK USING LINKED LIST -------------------------" );
		LinkedListStack linkedListStack = new LinkedListStack ();
		printLineConsoleOutput ( "Is Stack Empty : " + linkedListStack.isEmpty () );
		linkedListStack.push ( 1 );
		printLineConsoleOutput ( "Is Stack Empty : " + linkedListStack.isEmpty () );
		printLineConsoleOutput ( "Content of Stack : " + linkedListStack.toString () );
		linkedListStack.push ( 2 );
		linkedListStack.push ( 3 );
		printLineConsoleOutput ( "Content of Stack : " + linkedListStack.toString () );
		printLineConsoleOutput ( "Top Most Element in Stack : " + ( linkedListStack.top () == ArrayStack.INVALID_VALUE ? "Invalid Value" : linkedListStack.top () ) );
		linkedListStack.pop ();
		printLineConsoleOutput ( "Content of Stack : " + linkedListStack.toString () );
		linkedListStack.pop ();
		linkedListStack.pop ();
		printLineConsoleOutput ( "Top Most Element in Stack : " + ( linkedListStack.top () == ArrayStack.INVALID_VALUE ? "Invalid Value" : linkedListStack.top () ) );

		printLineConsoleOutput ( "REVERSE STRING USING STACK -------------------------" );
		ReverseString reverseString = new ReverseString ();
		printLineConsoleOutput ( "Reversed String : " + reverseString.reverse ( inputText () ) );
	}

	private void useQueue () {
		printLineConsoleOutput ( "\nQUEUE USING ARRAY -------------------------" );
		ArrayQueue arrayQueue = new ArrayQueue ( true );
		printLineConsoleOutput ( "Is Queue Empty : " + arrayQueue.isEmpty () );
		arrayQueue.enqueue ( 1 );
		printLineConsoleOutput ( "Contents of Queue : " + arrayQueue.toString () );
		arrayQueue.enqueue ( 2 );
		arrayQueue.enqueue ( 3 );
		arrayQueue.enqueue ( 4 );
		printLineConsoleOutput ( "Is Queue Empty : " + arrayQueue.isEmpty () );
		printLineConsoleOutput ( "Contents of Queue : " + arrayQueue.toString () );
		printLineConsoleOutput ( "Front : " + arrayQueue.front () );
		arrayQueue.dequeue ();
		printLineConsoleOutput ( "Is Queue Empty : " + arrayQueue.isEmpty () );
		printLineConsoleOutput ( "Contents of Queue : " + arrayQueue.toString () );

		printLineConsoleOutput ( "\nQUEUE USING LINKED LIST -------------------------" );
		LinkedListQueue linkedListQueue = new LinkedListQueue ();
		printLineConsoleOutput ( "Is Queue Empty : " + linkedListQueue.isEmpty () );
		printLineConsoleOutput ( "Content of Stack : " + linkedListQueue.toString () );
		linkedListQueue.enqueue ( 1 );
		linkedListQueue.enqueue ( 2 );
		linkedListQueue.enqueue ( 3 );
		printLineConsoleOutput ( "Is Queue Empty : " + linkedListQueue.isEmpty () );
		printLineConsoleOutput ( "Content of Stack : " + linkedListQueue.toString () );
		linkedListQueue.dequeue ();
		printLineConsoleOutput ( "Is Queue Empty : " + linkedListQueue.isEmpty () );
		printLineConsoleOutput ( "Content of Stack : " + linkedListQueue.toString () );
	}

	private void printLineConsoleOutput ( String message ) { System.out.println ( message ); }

	private void printConsoleOutput ( String message ) { System.out.print ( message ); }
}