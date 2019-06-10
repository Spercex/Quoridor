/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public class Player {

	private String playerName;
	private Square position;

	/**
	 * Constructor of player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name ;  name of the player
	 * @param board :  the current board
	 */

	public Player(String name, Board board) {
		// TODO - implement Player.Player
		throw new UnsupportedOperationException();
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

	public int getIntX(){
		return this.position.getX();
	}

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public int getIntY(){
		return this.position.getY();
	}

}
