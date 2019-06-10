package Quoridor.model;

//import static org.junit.jupiter.api.Assertions.*;

import Quoridor.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import Quoridor.model.*;

class AutoPlayerTest extends TestCase {
	private AutoPlayer autoPlayer;
	private String name;
	private Board board;

	public AutoPlayerTest(String name, Board board){
		super(name,board);
	}

	@BeforeAll
	static void setUp() throws Exception {
		super.setUp();
		this.autoPlayer = new AutoPlayer("Prénom1","Board");
	}

	@AfterAll
	static void tearDown() throws Exception {
		super.tearDown();
		this.autoPlayer = null;
	}

	public void testAutoPlayer(){
		assertNotNull("L'instance n'est pas créée",this.autoPlayer);
	}

	public void testGetIntX() throws Exception{
		if(this.autoPlayer.getX < 0 && this.autoPlayer.getX > 19){
			fail("ERROR x position !");
		}
	}

	public void testGetIntY() throws Exception{
		if(this.autoPlayer.getY < 0 && this.autoPlayer.getY > 19){
			fail("ERROR y position !");
		}
	}

	public void testGetAutoPlayerName(){
		assertEquals("Le prenom est incorrect", "Prénom1", AutoPlayer.getAutoPlayerName());
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
