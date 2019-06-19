/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

import model.*;

public class GameLauncher {

	/**
	 * Use to start the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param args
	 */

	 public static void main(String args[]){
		 	Game g = new Game("p1","p2", Mode.HH, 1);
			g.start();


	 }
}
