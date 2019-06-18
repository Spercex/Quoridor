/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;
import view.UI;

public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private UI ui;



	/**
	 * Construtor of the class Game
	 * Create the particularity of the two player
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param playerName1 the name of the first player
	 * @param playerName2 the name of the second player
	 * @param mode the mode of the game
	 */

	public Game(String player1Name, String player2Name, Mode mode) {
		this.board = new Board();
		switch (mode){
			case HH :
				this.player1 = new HumanPlayer(player1Name, 17, 9, this.board, TypeCase.P1);
				this.player2 = new HumanPlayer(player2Name, 1, 9, this.board, TypeCase.P2);
				break;

			case HA :
			this.player1 = new HumanPlayer(player1Name, 17, 9, this.board, TypeCase.P1);
			this.player2 = new AutoPlayer(player2Name, 1, 9, this.board, TypeCase.P2);
			break;

			case AA :
			this.player1 = new AutoPlayer(player1Name, 17, 9, this.board, TypeCase.P1);
			this.player2 = new AutoPlayer(player2Name, 1, 9, this.board, TypeCase.P2);
			break;

		}
	}

	public void setUIBoard(UI view){
		this.board.setUI(view);
	}

	/**
	 * Manage the end of the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return a boolean for stop the game
	 */

	public boolean endOfGame(){
		return !((this.player1.getX() == 1)||(this.player2.getX() == 17));
	}

	/**
	 * Manage the start of the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	public void start(){
		int data[] = new int[2];
		while(endOfGame()){
			data = player1.play(board.checkMoves(player1));
			if (data[0]==0){
				this.board.setPlayer(player1, data[1], data[2]);
			}
			else if (data[0] == 1){

			}
			data = player2.play(board.checkMoves(player2));
			if (data[0]==0){
				this.board.setPlayer(player2, data[1], data[2]);
			}
			else if(data[0] == 1){}
		}
		this.board.printBoard();

	}

	public Board getBoard(){
		return this.board;
	}

	public Player getPlayer1(){
		return this.player1;
	}

	public Player getPlayer2(){
		return this.player2;
	}





	public void printBoard(){
		this.board.printBoard();
	}
}
