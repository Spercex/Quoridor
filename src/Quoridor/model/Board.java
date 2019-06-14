/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.lang.RuntimeException.*;


public class Board {

	private Square[][] grid;
	private int size;

	/**
	 * Constructor of Board
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param fileName : String
	 */

	public Board() {
		this.size = 19;
		this.grid = new Square[size][size];

		for (int i = 0 ; i < size ; i++){
			for (int j = 0 ; j < size ; j++){
				this.grid[i][j] = new Square(i,j);

				if ( i == 0 || i == 18 || j == 0 || j == 18){
					this.grid[i][j].setType(typeCase.FORBIDDEN);
				}
				else if(i%2 == 0 || j%2 == 0 ){
					this.grid[i][j].setType(typeCase.FREEB);
				}
				else {
					this.grid[i][j].setType(typeCase.FREEP);
				}

			}
		}

	}

	/**
	 * check if there is a fence and if the move if allowed
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public ArrayList<Square> getLegalMoves(Player p) {
		int[][] moves = new int[4][2];
		ArrayList<Square> legalMoves = new ArrayList<Square>();
		moves[0][0]=-1;
		moves[0][1]= 0;

		moves[1][0]=0;
		moves[1][1]=1;

		moves[2][0]=1;
		moves[2][1]=0;

		moves[3][0]=0;
		moves[3][1]=-1;


		int[] playerPos = p.getPos();

		for (int[] coord : moves){				//switches moves direction
			try {


				if (this.grid[playerPos[0]+coord[0]][playerPos[1]+coord[1]].isFree()) { //checks whether the next square is free
					Square s = this.grid[playerPos[0]+2*coord[0]][playerPos[1]+2*coord[1]]; //

					if (s.isFree()){
						legalMoves.add(s);
					}


					else if (s.getType() == typeCase.P1 || s.getType() == typeCase.P2) { //checks if the next Square is occupied by a player
						Square nextS = this.grid[s.getX()+2*coord[0]][s.getY()+2*coord[1]];
						Square nextF = this.grid[s.getX()+coord[0]][s.getY()+coord[1]];

						if (nextS.isFree() && nextF.isFree()) {	//checks if the square behind the other player is free and fenceless
							legalMoves.add(this.grid[s.getX()+2*coord[0]][s.getY()+2*coord[1]]);
						}

						else if (nextF.getType() == typeCase.FENCE) {	//checks if the square behind the player is fenced
							if (playerPos[0]-s.getX() == 0){ //checks if the pawn are on the same X
								if (this.grid[s.getX()][s.getY()+1].isFree()){
									legalMoves.add(this.grid[s.getX()][s.getY()+2]);
								}
								else if (this.grid[s.getX()][s.getY()-1].isFree()){
									legalMoves.add(this.grid[s.getX()][s.getY()-2]);
								}
							}
							else if (playerPos[1]-s.getY() == 0){  //checks if the pawn are on the same Y
								if (this.grid[s.getX()+1][s.getY()].isFree()){
									legalMoves.add(this.grid[s.getX()+2][s.getY()]);
								}
								else if (this.grid[s.getX()-1][s.getY()].isFree()){
									legalMoves.add(this.grid[s.getX()-2][s.getY()]);
								}
							}
						}
					}
				}
			}
			catch (IndexOutOfBoundsException e){	}

		}
		return legalMoves;
	}

	/**
	 * Get the position of a player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param p : the player
	 * @return the position
	 */

	public int positionOf(Player p){
		return 0;
	}

	/**
	 * Gets the closest board corner from the given square
	 * @since openjdk version "11.0.3" 2019-03-14
	 * @param s : a Square
	 * @return the closest corner
	 */
	public Square getClosestCorner(Square s){
		Square ret = null;
		if (s.getPos()[0] < 9){
			if (s.getPos()[1] < 9){
				ret = new Square(0,0);
			}
			else {
				ret = new Square(18,0);
			}
		}
		else {
			if (s.getPos()[1] < 9){
				ret = new Square(0,18);
			}
			else {
				ret = new Square(18,18);
			}
		}
		return ret;
	}

/**
 * Gets the arraylist containing the unfenceable squares
 * @since openjdk version "11.0.3" 2019-03-14
 * @return the ArrayList which indicates what squares are forbidden to get a fence
 */
	public ArrayList<Square> getForbiddenFences(){
		return null;
	}

	public void setPlayer(Player p, int newX, int newY){
		try {
			if (newX%2 != 0 && newY%2 != 0){
				this.grid[p.getX()][p.getY()].setType(typeCase.FREEP);
				this.grid[newX][newY] = new Square(newX, newY, p.getType());
				p.setPos(this.grid[newX][newY]);
			}
			else {
				System.out.println("Board.setPlayer() : param error : (" + newX + ","+newY+") is not a playable square");
			}
		}
		catch (NullPointerException e){
			e.printStackTrace();
			System.out.println("former player pos : " + p.getX()+","+p.getY());
			System.out.println("former player pos : " + newX+","+newY);

		}
	}



	/**
	 * print the board on the screen
	 * @since openjdk version "11.0.3" 2019-04-16
	 */
	public void printBoard() {
		System.out.println(this.toString());
	}

	/**
	 * Get the grid
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the grid
	 */

	public Square[][] getGrid(){
		return this.grid;
	}

	public Square getSquare(int x, int y){
		Square ret = null;
		try {
			ret = this.grid[x][y];
		}
		catch (NullPointerException e){
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Converts the board to a displayable string in the term
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the String
	 */
	public String toString(){
		String ret = "";
		for (Square[] sqr : this.grid){
			for (Square s : sqr){
				switch (s.getType()){
					case FENCE :
						ret+="[FF]";
						break;

					case NONE :
						ret += "NONE";
						break;

					case FREEP :
						ret += "[FP]";
						break;

					case FREEB :
						ret += "|  |";
						break;

					case P1 :
						ret += "[P1]";
						break;

					case P2 :
						ret += "[P2]";
						break;

					case TAKEABLE :
						ret += "[00]";
						break;

					case FORBIDDEN :
						ret += "XXXX";
						break;
				}
			}
			ret+="\n";
		}
		return ret;
	}

}
