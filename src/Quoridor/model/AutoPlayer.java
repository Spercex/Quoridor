/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public class AutoPlayer extends Player {

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the HumanPlayer
	 * @param board :  the boards
	 */

	public AutoPlayer(String name, Board board) {
		// TODO - implement AutoPlayer.AutoPlayer
		super(name,board);
		throw new UnsupportedOperationException();
	}

	/**
	 * this method allows the Auto player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play() {
		// TODO - implement AutoPlayer.play
		throw new UnsupportedOperationException();
	}

	/**
	 * Getter for position X
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position X
	 */

	public int getX() {
		return this.getIntX();
	}

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public int getY() {
		return this.getIntY();
	}

	/**
	 * Getter for AutoPlayer's name
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the AutoPlayer's name
	 */

	public String getAutoPlayerName() {
		return this.getPlayerName();
	}

}
