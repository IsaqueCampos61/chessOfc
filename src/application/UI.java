package application;

import chess.ChessPiece;
import chess.Color;

public class UI {

    public  static  final  String  ANSI_RESET = "\u001B[0m" ;
    public  static  final  String  ANSI_BLACK = "\u001B[30m" ;
    public  static  final  String  ANSI_RED = "\u001B[31m" ;
    public  static  final  String  ANSI_GREEN = "\u001B[32m" ;
    public  static  final  String  ANSI_YELLOW = "\u001B[33m" ;
    public  static  final  String  ANSI_BLUE = "\u001B[34m" ;
    public  static  final  String  ANSI_PURPLE = "\u001B[35m" ;
    public  static  final  String  ANSI_CYAN = "\u001B[36m" ;
    public  static  final  String  ANSI_WHITE = "\u001B[37m" ;

    public  static  final  String  ANSI_BLACK_BACKGROUND = "\u001B[40m" ;
    public  static  final  String  ANSI_RED_BACKGROUND = "\u001B[41m" ;
    public  static  final  String  ANSI_GREEN_BACKGROUND = "\u001B[42m" ;
    public  static  final  String  ANSI_YELLOW_BACKGROUND = "\u001B[43m" ;
    public  static  final  String  ANSI_BLUE_BACKGROUND = "\u001B[44m" ;
    public  static  final  String  ANSI_PURPLE_BACKGROUND = "\u001B[45m" ;
    public  static  final  String  ANSI_CYAN_BACKGROUND = "\u001B[46m" ;
    public  static  final  String  ANSI_WHITE_BACKGROUND = "\u001B[47m" ;

    //esse faz referencia a matriz pieces da class Board
    public static void printBoard(ChessPiece[][] piecess){
        /* o length representa a leitura total do argumento em questão no caso a matriz (piecess)
        para imprimir em ordem decrescente ultilizamos (8-i)
         */
        for (int i=0; i < piecess.length; i++){
            System.out.print((8 - i)+ " ");
            for (int j = 0; j < piecess.length; j++){
                //esse metodo imprime a peça na posição [#][#] da matriz piecess
                printPiece (piecess[i][j]);
            }
            System.out.println();
            //esse print é representa a quebra de linha
        }
        //Esse vai imprimir apos as duas estruturas de repetição
        System.out.println("  a b c d e f g h");
    }

    /*private static void printPiece(ChessPiece piece){
        // o (piece) é um metodo da class Board
        //esse metodo imprime uma peça
        if (piece == null){
            System.out.print("-");

        } else {
            //caso seja diferente de nulo ele imprime a peça (piece)
            System.out.print(piece);
        }
        System.out.print(" ");
    }*/

    private static void printPiece(ChessPiece piece){
        if (piece == null){
            System.out.print("-");
        }
        else {
            if(piece.getColor() == Color.WHITE){
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
