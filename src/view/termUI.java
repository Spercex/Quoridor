package view;
import model.Game;

public class termUI implements UI{
  Game g;

  public termUI(Game g){
      this.g = g;
  }

  public void update(){
    g.printBoard();
  }
}
