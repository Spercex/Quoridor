/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public class Square {

	private int x;
	private int y;

	/**
	 * Contructor of Square
	 * Square is dentified by its coordinates (x,y)
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param x : coordinate x of the square
	 * @param y : coordinate y of the square
	 */

	public Square(int x, int y) {
		// TODO - implement Square.Square
		throw new UnsupportedOperationException();
	}

	/**
	 * Getter for position X
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position X
	 */

	public int getX() {
		return this.x;
	}

	/**
	 * Getter for position Y
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the position Y
	 */

	public int getY() {
		return this.y;
	}

	/**
	 * check if the square is free
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the answer
	 */

	public boolean isFree() {
		return false;
	}

	/**
	 * check if the square if forbidden
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the answer
	 */

	public boolean isForbidden() {
		return false;
	}

}
