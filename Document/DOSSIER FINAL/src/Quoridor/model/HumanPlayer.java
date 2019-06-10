/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public class HumanPlayer extends Player {

	private Scanner scan;

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the HumanPlayer
	 * @param board :  the board
	 */
	 
	public HumanPlayer(String name, Board board) {
		// TODO - implement HumanPlayer.HumanPlayer
		throw new UnsupportedOperationException();
	}

	/**
	 * this method allows the Human player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play() {
		// TODO - implement HumanPlayer.play
		throw new UnsupportedOperationException();
	}

	/**
	 * Getter for position X
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position X
	 */

	public int getIntX() {
		return this.x;
	}

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public int getIntY() {
		return this.y;
	}

}
