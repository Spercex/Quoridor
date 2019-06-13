/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

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
				if(i%2 == 0 || j%2 == 0 ){
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

	public void ckBarrieres() {
		// TODO - implement Board.ckBarrieres
		throw new UnsupportedOperationException();
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
	 * print the board on the screen
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void printBoard() {}

	/**
	 * Get the grid
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the grid
	 */

	public Square[][] getGrid(){
		return this.grid;
	}

	public String toString(){
		String ret = "";
		for (Square[] sqr : this.grid){
			for (Square s : sqr){
				switch (s.getType()){
					case FENCE :
						ret+="[FF]";
						break;

					case NONE :
						ret += "[xx]";
						break;

					case FREEP :
						ret += "[FP]";
						break;

					case FREEB :
						ret += "[FB]";
						break;

					case P1 :
						ret += "[P1]";
						break;

					case P2 :
						ret += "[P2]";
						break;
				}
			}
			ret+="\n";
		}
		return ret;
	}

}
