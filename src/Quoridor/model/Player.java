/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public abstract class Player {

	private String playerName;
	private Board board;
	private Square position;

	/**
	 * Constructor of player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name ;  name of the player
	 * @param board :  the current board
	 */

	public Player(String name, Board board) {
		// TODO - implement Player.Player
		if( (name != null) && (board != null)) {
			this.playerName = name;
			this.board = board;
		}else {
			System.out.println("Player() : wrong parameter !");
		}
	}


	/**
	* This method allows the player to play his turn
	* @since openjdk version "11.0.3" 2019-04-16
	*/
	public abstract void play();
	
	
	/**
	 * Getter for player's name
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public abstract String getPlayerName();		

	
	/**
	 * Getter for the position
	 * @since openjdk version "11.0.3" 2019-04-16
	 */
	public Square getSquare(){
		return this.position;
	}

	/**
	 * Getter for position X
	 * @since openjdk version "11.0.3" 2019-04-16

	 */

	public abstract int getIntX();

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public abstract int getIntY();

}
