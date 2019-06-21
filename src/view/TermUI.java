package view;
import model.Game;

public class TermUI implements UI{
  Game g;

  public TermUI(Game g){
      this.g = g;
  }

  public void update(){
    g.printBoard();
  }
}
