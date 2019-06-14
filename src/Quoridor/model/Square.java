/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F, KHALIFA Y, BAUSSON T
*/

package Quoridor.model;

public class Square {

	private int x;
	private int y;

	private TypeCase c;

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
	 * Contructor of Square
	 * Square is dentified by its coordinates (x,y)
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param x : coordinate x of the square
	 * @param y : coordinate y of the square
	 * @param t : the type of the square
	 */
	public Square(int x, int y, TypeCase t) {
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
		this.c = t;
	}

	/**
	 * Gets the position of the square in an int[2]
	 * @since openjdk version "11.0.3" 2019-06-14
	 * @return [x,y]
	 **/
	public int[] getPos(){
		int[] ret = new int[2];
		ret[0] = this.x;
		ret[1] = this.y;
		return ret;
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
		return (c == TypeCase.FREEP || c == TypeCase.FREEB) ? true : false;
	}

	/**
	 * check if the square if forbidden
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @return the answer
	 */

	public TypeCase getType() {
		return this.c;
	}

	public void setType(TypeCase c){
		this.c = c;
	}

	public String toString(){
		return "<Square ("+this.x+","+this.y+") is " + this.c+">";
	}

}
