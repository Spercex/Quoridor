/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F
*/

package Quoridor.model;

public class Game implements IGame{
	private Player player1, player2;
	private Mode mode;
	private Square[][] grid;
	private int nbTour = 0;
	private Board board;

	/**
	 * This method is a shortcut from System.out.println
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param value - value to print
	 */

	public void sop(String value){
		System.out.println(value);
	}


	/**
	 * This method is a shortcut from System.err.println
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param value - value to print
	 */

	public void sep(String value){
		System.err.println(value);
	}


	/**
	 * Construtor of the class Game
	 * Create the particularity of the two player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param playerName1 - First player's name
	 * @param playerName2 - Second player's name
	 * @param mode - game mode
	 */

	public Game(String player1, String player2, Mode mode) {
		// TODO - implement Game.Game
		this.board = new Board();
		initializeBoard();
		if(mode == Mode.HH){
			this.player1 = new HumanPlayer(playerName1, board);
			this.player2 = new HumanPlayer(playerName2, board);
			play(); //A CODER
		}else if(mode == Mode.HA){
			this.player1 = new HumanPlayer(playerName1, board);
			this.player2 = new AutoPlayer(playerName2, board);
			play2(); //A CODER
		}else{
			this.player1 = new AutoPlayer(playerName1, board);
			this.player2 = new AutoPlayer(playerName2, board);
			play3(); //A CODER
		}
	}

	/**
	 * play the game
	 * In Human vs. Human mode with the keyboard
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play(){

	}

	/**
	 * play the game
	 * In Human vs. Auto mode with the keyboard
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play2(){

	}

	/**
	 * play the game
	 * In Auto vs. Auto
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void play3()

	/**
	 * Manage the end of the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return a boolean for stop the game
	 */

	public boolean endOfGame(){
		return false;
	}

	/**
	 * Manage the start of the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void start(){

	}
}
