/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class HumanPlayer extends Player {

	private Scanner scan;

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the HumanPlayer
	 */

	public HumanPlayer(String name, int x, int y, Board board, TypeCase t){
		// TODO - implement HumanPlayer.HumanPlayer
		super(name,board, x, y, t);
		this.scan = new Scanner(System.in);

	}

	/**
	 * this method allows the Human player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public int[] play(ArrayList<Square> legalMoves) {
		int[] move = new int[2];
		int[] newPos = new int[2];
		int x;
		do{
			System.out.println("> " +this.getName() + " : Entrer un déplacement : ");
			try {
				x = scan.nextInt();
				if (x == 8) { move[0] = -2; move[1] = 0;}
				else if (x == 2) { move[0] = 2; move[1] = 0;}
				else if (x == 4) { move[0] = 0; move[1] = -2;}
				else if (x == 6) { move[0] = 0; move[1] = 2;}
			}
			catch (InputMismatchException e){
				System.out.println("Entrer un déplacement valide.");
			}
		}
		while (isLegalSquare(move,legalMoves));
		newPos[0] = this.getX() + move[0];
		newPos[1] = this.getY() + move[1];


		return newPos;

	}

	public boolean isLegalSquare(int[] move, ArrayList<Square> legalMoves){
		boolean ret = false;
		int x = this.getX()+move[0];
		int y = this.getY()+move[1];

		for (Square s : legalMoves){
			ret = ((s.getX() == this.getX() + x) && (s.getY() == this.getY() + y));
		}
		return ret;
	}



}
