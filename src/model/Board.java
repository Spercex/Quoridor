/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import view.UI;


public class Board {

	private Square[][] grid;
	private ArrayList<Square> forbiddenFences;
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

		this.forbiddenFences = new ArrayList<>();

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
		this.ui.update();
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
		p.setMoves(legalMoves);

		//System.out.println(" in getLegalMoves " + p.getMoves().toString());


		return legalMoves;
	}

	public void setUI(UI view){
		this.ui = view;
	}
/*
	public ArrayList<Square> checkMoves(Player p){
		ArrayList<Square> legalMoves = getLegalMoves(p);
		resetGrid();
		for (Square s : legalMoves){
			s.setType(TypeCase.TAKEABLE);
		}
		//this.ui.update();
		printBoard();
		return legalMoves;
	}
*/
	public void checkMoves(Player p){
		getLegalMoves(p);
		resetGrid();
		System.out.println(p.getName() + ":\n");
		for (Square s : p.getMoves()){
			s.setType(TypeCase.TAKEABLE);
			//System.out.println(s.toString());

		}
		this.ui.update();
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








	public void setPlayer(Player p, int newX, int newY){
		if (p.getMoves() != null){
			try {
				//System.out.println(newX%2 != 0 && newY%2 != 0 && newX >= 0 && newY>=0
				//		&& newX < this.size && newY	 < this.size);
				//System.out.println(this.grid[newX][newY].getType()==TypeCase.TAKEABLE);
				//System.out.println("in setPlayer : " +p.getMoves().toString());

				if (newX%2 != 0 && newY%2 != 0 && newX >= 0 && newY>=0
						&& newX < this.size && newY	 < this.size
						&& this.grid[newX][newY].getType()==TypeCase.TAKEABLE){
					this.grid[p.getX()][p.getY()].setType(TypeCase.FREEP);
					this.grid[newX][newY].setType(p.getType());

					//this.grid[newX][newY] = new Square(newX, newY, p.getType());
					p.setPos(this.grid[newX][newY]);
					this.ui.update();
				}
				else {
					System.out.println("Board.setPlayer() : param error : player : "+p.getName()+" (" + newX + ","+newY+") is not a playable square");
				}
			}
			catch (NullPointerException e){
				e.printStackTrace();
				System.out.println("former player pos : " + p.getX()+","+p.getY());
				System.out.println("player pos : " + newX+","+newY);
			}
		}
		else {
			System.out.println("Board.setPlayer() : param error : player.getMoves() is null");
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
				this.ui.update();

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
			this.ui.update();
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
						System.out.println(s.toString());
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

	public void setForbiddenFences(Player p){
		this.forbiddenFences.add(BFS(p.getX(),p.getY()));
	}

	public ArrayList<Square> getForbiddenFences(){
		return this.forbiddenFences;
	}


	/**
	 * PathFiding algorith :search if the player ca reach the end of the board or if it is impossible
	 * @param x : coordinate x
	 * @param y : coordinate y
	 * @return
	 */
	public Square BFS(int x, int y){
		Queue<Square> q = new LinkedList<Square>();
		LinkedList<Square> visited = new LinkedList<Square>();
		Square current = new Square(x,y);

		boolean finished = false;

		q.add(current);
		visited.add(current);

		while(!q.isEmpty() && !finished ){
			current = q.remove();
			Player player = new Player("p", this, current);
			this.checkMoves(player);
			for(Square p : player.getMoves()){
				if(!visited.contains(p)){
					visited.add(p);
					q.add(p);
					if(endVerif(p,this.grid[x][y].getType())){
						current = p;
						finished = true;
						break;
					}
				}
			}
		}
		return current;
	}

	/**
	 * check if the position of the square searched by the player is the end
	 * @param sq : the square to check
	 * @param player : color of the player
	 * @return true if the actual sq is the end for this player
	 */
	public boolean endVerif(Square sq, TypeCase player){
		boolean ret = false;
		if(player == TypeCase.P1){
			if(sq.getX() == 0){
				ret = true;
			}
		}
		else if(player == TypeCase.P2){
			if(sq.getX() == 17){
				ret = true;
			}
		}
		return ret;
	}



}
