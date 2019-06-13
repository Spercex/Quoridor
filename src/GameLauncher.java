/**
* @author BOURDIN M, SCHLOSSER M, LE FEUNTEUN F
*/

public class GameLauncher {

	/**
	 * This method is a shortcut from System.out.println
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param value - value to print
	 */

	public static void sop(String value){
		System.out.println(value);
	}

	/**
	 * This method is a shortcut from System.err.println
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param value - value to print
	 */

	public static void sep(String value){
		System.err.println(value);
	}


	/**
	 * Use to start the game
	 * @since openjdk version "11.0.3" 2019-04-16
	 * @param args
	 */

	public void main(String[] args) {
		// TODO - implement GameLauncher.main
		sop("\033[31m\n==== Début DU PROGRAMME Quoridor.java ====\033[0m");
		sop("\033[32m   /=/SCHLOSSER M, BOURDIN M, LE FEUNTEUN F, INFO 1C2 /=/ \n\033[0m");

		QuoridorN quori = new QuoridorN("../src/configure.txt", "Tee", "Perce");

		sop("\033[31m\n==== Fin DU PROGRAMME Quoridor.java ====\033[0m");
		sop("\033[32m   /=/SCHLOSSER M, BOURDIN M, LE FEUNTEUN F, INFO 1C2 /=/ \n\033[0m");

	}

}
