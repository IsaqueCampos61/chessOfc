package application;

import chess.ChessPiece;

public class UI {

    //esse faz referencia a matriz pieces da class Board
    public static void printBoard(ChessPiece[][] piecess){
        /* o length representa a leitura total do argumento em questão no caso a matriz (pieces)
        para imprimir em ordem decrescente ultilizamos (8-i)
         */
        for (int i=0; i < piecess.length; i++){
            System.out.print((8 - i)+ " ");
            for (int j = 0; j < piecess.length; j++){
                //esse metodo imprime a peça na posição [#][#] da matriz pieces
                printPiece (piecess[i][j]);
            }
            System.out.println();
            //esse print é representa a quebra de linha
        }
        //Esse vai imprimir apos as duas estruturas de repetição
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece){
        // o (piece) é um metodo da class Board
        //esse metodo imprime uma peça
        if (piece == null){
            System.out.print("-");
        } else {
            //caso seja diferente de nulo ele imprime a peça (piece)
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
