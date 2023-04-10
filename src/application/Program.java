package application;

import boardgame.Board;
import boardgame.PieceBG;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        //Instanciando Board
        Board board = new Board(8,8);
        System.out.println(board.getRows());
        //Entendendo Position
        Position pos = new Position();
        System.out.println(pos);
        */

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition sourse = UI.readChessPosition(sc);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChesMove(sourse, target);
                }
                catch (ChessException e){
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
                catch (InputMismatchException e){
                  System.out.println(e.getMessage());
                  sc.nextLine();
                }

            }
    }
}
