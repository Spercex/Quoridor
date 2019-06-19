/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import view.*;


public class HumanPlayer extends Player {

	private Scanner scan;
	private UI ui;
	private int[] clicked;
	boolean wait;

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the HumanPlayer
	 */

	public HumanPlayer(String name, int x, int y, Board board, TypeCase t, UI view){
		// TODO - implement HumanPlayer.HumanPlayer
		super(name,board, x, y, t);
		this.scan = new Scanner(System.in);
		this.clicked = new int[2];
		this.clicked[0] = -1;
		this.clicked[1] = -1;

	}

	/**
	 * this method allows the Human player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public int[] play(ArrayList<Square> legalMoves) {
		int[] data = new int[2];
		int[] ret = new int[3];
		int x=-1;
		if (this.ui instanceof termUI){
			do{
				System.out.println("> " +this.getName() + " : "+"\n\t>> 0 pour se déplacer "
																											 +"\n\t>> 1 pour poser un mur ");
				try {
					x = scan.nextInt();
					if (x == 0) { data = movePlayer(legalMoves);}
					else if ( x== 1) { data = placeFence(null);}

				}
				catch (InputMismatchException e){
					System.out.println("Entrer un déplacement valide.");
				}
			}
			while ( x!=0 && x != 1);
			ret[0] = x;
			ret[1] = data[0] ;
			ret[2] = data[1];
		}
		else {
			System.out.println("> " +this.getName() + " : Entrer un déplacement : ");
			this.wait = true;
			do {
				//System.out.println(clicked[0]+","+clicked[1]);
				this.wait = true;

				while (this.wait){
					//System.out.println(clicked[0]+","+clicked[1]);
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (this.clicked[0] !=-1 && this.clicked[1] != -1){
						System.out.println(clicked[0]+","+clicked[1]);

						data = this.clicked;
						this.wait = false;
						System.out.println(data[0]+","+data[1]);

						System.out.println(data);
					}
				}
				System.out.println("out of 1st while");

			}
			while(isLegalSquare(data,legalMoves));
		}

		ret[0] = 0;
		ret[1] = data[0] ;
		ret[2] = data[1];
		this.clicked[0] = -1;
		this.clicked[1] = -1;


		return ret;

	}

	public int[] movePlayer(ArrayList<Square> legalMoves){
		int[] move = new int[2];
		int[] newPos = new int[2];
		int x;
		do{
			if (this.ui instanceof termUI){
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

		}
		while (isLegalSquare(move,legalMoves));
		newPos[0] = this.getX() + move[0];
		newPos[1] = this.getY() + move[1];


		return newPos;
	}

	public void setClicked(int[] data ){
		this.clicked = data;
		this.wait = false;
		System.out.println("in setClicked : " + clicked[0]+","+clicked[1] + " wait : " + wait);

	}

	public int[] getClicked(){
		return this.clicked;
	}



	public int[] placeFence(ArrayList<Square> forbiddenFences){
		int[] pos = new int[2];
		int x, y;


		do{
			System.out.println("> " +this.getName() + " : Entrer l'emplacement en x d'une barriere : ");
			try {
				x = scan.nextInt();
				pos[0] = x;
			}
			catch (InputMismatchException e){
				System.out.println("Entrer un emplacement de barriere valide.");
			}
			System.out.println("> " +this.getName() + " : Entrer l'emplacement en y d'une barriere : ");
			try {
				y = scan.nextInt();
				pos[1] = y;
			}
			catch (InputMismatchException e){
				System.out.println("Entrer un emplacement de barriere valide.");
			}
		}
		while(isForbiddenFence(pos, forbiddenFences));

		return pos;
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

	public boolean isForbiddenFence(int[] pos, ArrayList<Square> forbiddenFences){
		boolean ret = true;

		for (Square s : forbiddenFences){
			ret = !((s.getX() == pos[0]) && (s.getY() == pos[1]));
		}
		return ret;
	}


}
