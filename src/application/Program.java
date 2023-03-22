package application;

import boardgame.Board;
import boardgame.Position;

public class Program {
    public static void main(String[] args) {

        //Instanciando Board
        Board board = new Board(8,8);
        System.out.println(board.getRows());
        //Entendendo Position
        Position pos = new Position();
        System.out.println(pos);
    }
}
