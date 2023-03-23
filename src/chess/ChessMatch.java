package chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        // é nessa classe que estará definido o temanho do tabuleiro
        board = new Board(8,8);
    }

    // A principio ele retorna uma matriz de peças de xadrez
    // Ele é uma sub classe de PieceBG e consegue acessar a matriz pieces do Board
    //A principal função dele é fazer com que o programa Enxergue a camada de xadrez (Chess) e não a camada interna de tabuleiro
    public ChessPiece[][] getPieces() {
        //aqui criamos a matriz (mat) que recebe a quantidade de rows e columns do tabuleiro
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumns(); j++){
                //esse (ChessPiece) é um downcast para ele interpretar como uma peça de xadrez e não uma peça comum
                mat [i][j] =(ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
}
