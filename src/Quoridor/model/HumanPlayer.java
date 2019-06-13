/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F
*/

package Quoridor.model;

import java.util.*;

public class HumanPlayer extends Player {

	private Scanner scan;

	/**
	 * Constructor of the class HumanPlayer
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param name : the name of the HumanPlayer
	 * @param board :  the board
	 */

	public HumanPlayer(String name, Board board){
		// TODO - implement HumanPlayer.HumanPlayer
		super(name,board);
		this.sc = new Scanner(System.in);
	}

	/**
	 * this method allows the Human player to play his turn
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play() {
		// TODO - implement HumanPlayer.play

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
	 * Getter for HumanPlayer's name
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the HumanPlayer's name
	 */

	public String getHumanPlayerName() {
		return this.getPlayerName();
	}

	/**
	 * Getter for HumanPlayer's position
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the HumanPlayer's position
	 */

	public Square getHumanPlayerPosition(){
		return this.getSquare();
	}

}
