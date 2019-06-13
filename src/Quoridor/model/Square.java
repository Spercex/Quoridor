/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F
*/

package Quoridor.model;

public class Square {

	private int x;
	private int y;

	private typeCase c;

	/**
	 * Contructor of Square
	 * Square is dentified by its coordinates (x,y)
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param x : coordinate x of the square
	 * @param y : coordinate y of the square
	 */

	public Square(int x, int y) {
		// TODO - implement Square.Square
		if (x >= 0 && x < 19){
			this.x = x;

		}
		else {
		System.out.println("x is out of bound");
		}
		if ( y >= 0 && y < 19 ) {
			this.y = y;
		}
		else {
		System.out.println("y is out of bound");
		}

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
		return (c == typeCase.FREEP || c == typeCase.FREEB) ? true : false;
	}

	/**
	 * check if the square if forbidden
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the answer
	 */

	public typeCase getType() {
		return this.c;
	}

	public void setType(typeCase c){
		this.c = c;
	}

}
