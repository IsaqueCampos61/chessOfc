package chess;

import PiecesChess.King;
import PiecesChess.Rook;
import boardgame.Board;
import boardgame.PieceBG;
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

    //Essa é a operação de mover peça
    // contendo posição de origem (source) e posição de destino (target)
    //
    public ChessPiece performChesMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        //POsição de origem
        //Aquie ele está sendo convertido para uma posição na matriz
        Position sourse = sourcePosition.ToPosition();
        //Posição de destino
        //Aquie ele está sendo convertido para uma posição na matriz
        Position target = targetPosition.ToPosition();
        //Aqui esse motodo verifica se na posição de origem havia uma peça
        //caso não seja valido vai cair na exceção
        validateSoursePosition (sourse);
        //Aqui essa operação recebe o resultado a operação makeMove
        // passando como argumaneto as posições de origem e destino ja como matriz
        PieceBG capturedPiece = makeMove(sourse, target);
        return (ChessPiece) capturedPiece;
    }

    //Essa operação realiza um movimento
    private PieceBG makeMove(Position sourse, Position target){
        //Aqui ele retira a peça que está na posição de origem
        PieceBG p = board.removePiece(sourse);
        //aqui ele remove a possivel peça que esteja naposição de destino
        // capturando
        PieceBG capturedPiece= board.removePiece(target);
        //Agora a peça que essa pessa de origem vai para a posição de destino
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSoursePosition (Position position){
        //caso não exita uma peca na posição informada
        // cai na exceção
        if (!board.thereIsAPiece(position)){
            throw new ChessException("Position not on the board");
        }

        if (!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece");
        }
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
