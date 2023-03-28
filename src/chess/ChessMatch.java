package chess;

import PiecesChess.King;
import PiecesChess.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        // é nessa classe que estará definido o tamanho do tabuleiro
        board = new Board(8,8);
        initialSetup();
    }

    // A principio ele retorna uma matriz de peças de xadrez
    // Ele é uma sub classe de PieceBG e consegue acessar a matriz pieces do Board
    //A principal função dele é fazer com que o programa Enxergue a camada de xadrez (Chess) e não a camada interna de tabuleiro
    public ChessPiece[][] getPieces() {
        //aqui criamos a matriz (mat) que recebe a quantidade de rows e columns do tabuleiro
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumns(); j++){
                //esse (ChessPiece) é um downcast para ele enterpretar como uma peça de xadrez e não uma peça comum
                mat [i][j] =(ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
    //Aqui temos uma operção de colocar peças passando as cordenadas do xadrez
    private void placeNewPiece (char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).ToPosition());
    }

    //Agora no cetup podemos passar as cordenadas do xadrez
    private void initialSetup(){
        /*
        metodo anterior ao Conversor (placeNewPiece)
        board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
        */

        //New Metodo
       placeNewPiece('b', 6,new Rook(board, Color.WHITE));
       placeNewPiece('e', 8,new King(board, Color.BLACK));
       placeNewPiece('e', 1,new King(board, Color.WHITE));

    }
}
