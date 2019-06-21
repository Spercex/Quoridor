/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;
import java.util.ArrayList;

public class Player {

	private String name;
	private Square position;
	private TypeCase t;
	private ArrayList<Square> legalMoves;
	private Board board;

	/**
	 * Constructor of player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name ;  name of the player
	 */

	public Player(String name, Board board, int x, int y, TypeCase type) {
		if( (name != null) && (board != null)) {
			this.name = name;
			this.position = board.getSquare(x,y);
			this.board = board;
			this.t = type;
			this.position.setType(this.getType());
			this.legalMoves = new ArrayList<>();
		}else {
			System.out.println("Player() : wrong parameter !");
		}
}

public Player(String name, Board board, Square sqr) {
	if( (name != null) && (board != null)) {
		this.name = name;
		this.position = sqr;
		//this.t = type;
		//this.position.setType(this.getType());
		this.legalMoves = new ArrayList<>();


	}else {
		System.out.println("Player() : wrong parameter !");
	}
}


	/**
	* This method allows the player to play his turn
	* @since openjdk version "11.0.3" 2019-04-16
	*/

	public int[] play(ArrayList<Square> legalMoves) {
		// TODO - implement Player.play
		throw new UnsupportedOperationException();
	}

	public int[] play(){
		throw new UnsupportedOperationException();

	};

	/**
	 * Getter for player's name
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the player's name
	 */

	public String getName() {
		return this.name;
	}

	public Board getBoard(){
		return this.board;
	}

	public Square getSquare(){
		return this.position;
	}

	/**
	 * Getter for position X
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position X
	 */

	public int getX(){
		return this.position.getX();
	}

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public int getY(){
		return this.position.getY();
	}

	public int[] getPos(){
		int[]ret = new int[2];
		ret[0]=this.position.getX();
		ret[1]=this.position.getY();

		return ret;
	}

	/**
	 * Sets the position of the player
	 * @since openjdk version "11.0.3" 2019-06-14
	 * @param pos the square where the palyer wille be placed
	 **/
	public void setPos(Square pos){
		this.position = pos;
	}

	/**
	 * Gets the position square of a player
	 * @return this.position square
	 */
	public Square getPosition(){
		return this.position;
	}

	public TypeCase getType(){
		return this.t;
	}

	public void setType(TypeCase type){
		this.t = type;
	}

	public ArrayList<Square> getMoves(){
		return this.legalMoves;
	}

	public void setMoves( ArrayList<Square> sqr){
		this.legalMoves = sqr;
		System.out.println(" in setMoves " + sqr.toString());

	}


	public String toString(){
		return "< Player is : " + this.name +" ; position is ("+getX()+","+getY()+") ; type is "+ this.t+">";
	}

}
