/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.lang.RuntimeException.*;

import view.UI;


public class Board {

	private Square[][] grid;
	private int size;
	private UI ui;

	/**
	 * Constructor of Board
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param fileName : String
	 */

	public Board() {
		this.size = 19;
		//this.ui = view;
		this.grid = new Square[size][size];

		for (int i = 0 ; i < size ; i++){
			for (int j = 0 ; j < size ; j++){
				this.grid[i][j] = new Square(i,j);

				if ( i == 0 || i == 18 || j == 0 || j == 18){
					this.grid[i][j].setType(TypeCase.FORBIDDEN);
				}
				else if(i%2 == 0 || j%2 == 0 ){
					this.grid[i][j].setType(TypeCase.FREEB);
				}
				else {
					this.grid[i][j].setType(TypeCase.FREEP);
				}

			}
		}

	}

	public void resetGrid(){
		for (Square[] sqr : this.grid){
			for (Square s : sqr){
				if (s.getType() == TypeCase.TAKEABLE){
					s.setType(TypeCase.FREEP);
				}
				else if (s.getType() == TypeCase.FORBIDDEN){
					s.setType(TypeCase.FREEB);
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


					else if (s.getType() == TypeCase.P1 || s.getType() == TypeCase.P2) { //checks if the next Square is occupied by a player
						Square nextS = this.grid[s.getX()+2*coord[0]][s.getY()+2*coord[1]];
						Square nextF = this.grid[s.getX()+coord[0]][s.getY()+coord[1]];

						if (nextS.isFree() && nextF.isFree()) {	//checks if the square behind the other player is free and fenceless
							legalMoves.add(this.grid[s.getX()+2*coord[0]][s.getY()+2*coord[1]]);
						}

						else if (nextF.getType() == TypeCase.FENCE) {	//checks if the square behind the player is fenced
							if (playerPos[1]-s.getY() == 0){ //checks if the pawn are on the same X
								if (this.grid[s.getX()][s.getY()+1].isFree()){
									if (!this.grid[s.getX()][s.getY()+2].equals(p.getPosition())){
										legalMoves.add(this.grid[s.getX()][s.getY()+2]);
									}
								}
								else if (this.grid[s.getX()][s.getY()-1].isFree()){
									if (!this.grid[s.getX()][s.getY()-2].equals(p.getPosition())){
										legalMoves.add(this.grid[s.getX()][s.getY()-2]);
									}
								}
							}
							else if (playerPos[0]-s.getX() == 0){  //checks if the pawn are on the same Y
								if (this.grid[s.getX()+1][s.getY()].isFree()){
									if (!this.grid[s.getX()+2][s.getY()].equals(p.getPosition())){
										legalMoves.add(this.grid[s.getX()+2][s.getY()]);
									}
								}
								else if (this.grid[s.getX()-1][s.getY()].isFree()){
									if (!this.grid[s.getX()-2][s.getY()].equals(p.getPosition())){
										legalMoves.add(this.grid[s.getX()-2][s.getY()]);
									}
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

	public void setUI(UI view){
		//this.ui = view;
	}

	public ArrayList<Square> checkMoves(Player p){
		ArrayList<Square> legalMoves = getLegalMoves(p);
		resetGrid();
		for (Square s : legalMoves){
			s.setType(TypeCase.TAKEABLE);
		}
		printBoard();
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
		Square s = null;
		ArrayList<Square> forbiddenFences = new ArrayList<Square>();
		for (int i = 0 ; i < this.size ; i+=2){
			for (int j = 0 ; j < this.size ; j+=2){

				s = this.grid[i][j];

				for (int dx = -1 ; dx < 2 ; dx++){
					for (int dy = -1 ; dy < 2 ; dy++){

						if (s.getType() == TypeCase.FENCE){
							//while (){
									System.out.println("CheckingFences");
							//}
						}
					}
				}
			}
		}
		return null;
	}



	public void setPlayer(Player p, int newX, int newY){
		try {
			if (newX%2 != 0 && newY%2 != 0 && newX >= 0 && newY>=0
					&& newX < this.size && newY	 < this.size
					&& this.grid[newX][newY].getType()==TypeCase.TAKEABLE){
				this.grid[p.getX()][p.getY()].setType(TypeCase.FREEP);
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
			System.out.println("player pos : " + newX+","+newY);
		}
	}

	public void setPlayer(Player p, int[] newPos){
		int newX = newPos[0];
		int newY = newPos[1];
		try {
			if (newX%2 != 0 && newY%2 != 0 && newX >= 0 && newY>=0
					&& newX < this.size && newY	 < this.size
					&& this.grid[newX][newY].getType()==TypeCase.TAKEABLE){
				this.grid[p.getX()][p.getY()].setType(TypeCase.FREEP);
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
			System.out.println("player pos : " + newX+","+newY);
		}
	}


	public void setFence(int x, int y, int dir){
		try {
			if ((!(x%2!=0 && y%2!=0)) && x < this.size && y < this.size && this.grid[x][y].getType()==TypeCase.FREEB){
				this.grid[x][y] = new Square(x, y, TypeCase.FENCE);
				if (dir == 1){
					if (x < this.size-2){
						this.grid[x+1][y] = new Square(x, y, TypeCase.FENCE);
						this.grid[x+2][y] = new Square(x, y, TypeCase.FENCE);
					}
					else {
						this.grid[x-1][y] = new Square(x, y, TypeCase.FENCE);
						this.grid[x-2][y] = new Square(x, y, TypeCase.FENCE);
					}
				}
				else if (dir == 0){
					if (y < this.size-2){
						this.grid[x][y+1] = new Square(x, y, TypeCase.FENCE);
						this.grid[x][y+2] = new Square(x, y, TypeCase.FENCE);
					}
					else {
						this.grid[x][y-1] = new Square(x, y, TypeCase.FENCE);
						this.grid[x][y-2] = new Square(x, y, TypeCase.FENCE);
					}
				}
			}
			else {
				System.out.println("Board.setPlayer() : param error : (" + x + ","+ y +") is not a fenceable square");
			}
		}
		catch (NullPointerException e){
			e.printStackTrace();
			System.out.println("fence pos : " + x +"," + y);
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

	public int getSize(){
		return this.size;
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
				ret+= TermColors.RESET;
				switch (s.getType()){
					case FENCE :
						ret+="[FF]";
						break;

					case NONE :
						ret += "NONE";
						break;

					case FREEP :
						ret += TermColors.WHITE_BOLD_BRIGHT + "[FP]";
						break;

					case FREEB :
						ret += "    ";
						break;

					case P1 :
						ret += TermColors.BLUE_BRIGHT + "[P1]";
						break;

					case P2 :
						ret += TermColors.RED + "[P2]";
						break;

					case TAKEABLE :
						ret += TermColors.YELLOW_BRIGHT + "[00]";
						break;

					case FORBIDDEN :
						ret += TermColors.BLACK + "XXXX";
						break;
				}
			}
			ret+="\n";
		}
		return ret+TermColors.RESET;
	}

}
