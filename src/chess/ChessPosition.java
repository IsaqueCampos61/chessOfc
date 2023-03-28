package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int  row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8 ){
            throw new RuntimeException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }
    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    /* Esse metodo converte O ChessPosition para umas position normal
    ele ultiliza uma formula geral
    subtraindo a linha da matrix = 8 - chessRow a linha do xadrez
    de forma parecida faremos o mesmo com os caracteres
    'a' - 'a' = 0
    'b' - 'b' = 1
    'c' - 'c' = 2
    . . .
        Assim a formula fica : coluna da matriz = chessColumn - 'a'
 */
    protected Position ToPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition ((char)( 'a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row;
    }
}
