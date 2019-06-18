/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;
import java.util.ArrayList;

public class AutoPlayer extends Player {

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the AutoPlayer
	 * @param board :  the boards
	 */

	public AutoPlayer(String name, int x, int y, Board board, TypeCase t) {
		// TODO - implement AutoPlayer.AutoPlayer
		super(name, board, x, y, t);
		throw new UnsupportedOperationException();
	}

	/**
	 * this method allows the Auto player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public int[] play(ArrayList<Square> legalMoves) {
		// TODO - implement AutoPlayer.play
		throw new UnsupportedOperationException();
	}




}
