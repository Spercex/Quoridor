/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package model;

public interface IGame {

	/**
	 * Abstract Method (Describe the game)
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	String description();

	/**
	 * Abstract Method (Manage the start of the game)
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	void start();

	/**
	 * Abstract Method (Mange the end of the game)
	 * @since openjdk version "11.0.3" 2019-04-16
	 */

	void endOfGame();

}
