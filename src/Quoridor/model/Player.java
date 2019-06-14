/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;


public class Player {

	private String playerName;
	private Square position;
	private Board board;
	private typeCase t;

	/**
	 * Constructor of player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name ;  name of the player
	 * @param board :  the current board
	 */

	public Player(String name, Board board, int x, int y, typeCase type) {
		if( (name != null) && (board != null)) {
			this.playerName = name;
			this.board = board;
			this.position = this.board.getSquare(x,y);
			this.t = type;
			this.position.setType(this.getType());
		}else {
			System.out.println("Player() : wrong parameter !");
		}
}

public Player(String name, Board board) {
	if( (name != null) && (board != null)) {
		this.playerName = name;
		this.board = board;
		this.position = this.board.getSquare(1,1);
		this.t = typeCase.P1;
		this.position.setType(this.getType());


	}else {
		System.out.println("Player() : wrong parameter !");
	}
}


	/**
	* This method allows the player to play his turn
	* @since openjdk version "11.0.3" 2019-04-16
	*/

	public void play() {
		// TODO - implement Player.play
		throw new UnsupportedOperationException();
	}

	/**
	 * Getter for player's name
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the player's name
	 */

	public String getPlayerName() {
		return this.playerName;
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
	 **/
	public void setPos(Square pos){
		this.position = pos;
	}

	public typeCase getType(){
		return this.t;
	}

	public void setType(typeCase type){
		this.t = type;
	}

	public String toString(){
		return "< Player is : " + this.playerName +" ; position is ("+getX()+","+getY()+") ; type is "+ this.t+">";
	}

}
