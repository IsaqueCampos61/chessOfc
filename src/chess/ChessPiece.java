package chess;

import boardgame.Board;
import boardgame.PieceBG;

//Essa é umas das subClasses de PieceBG
public abstract class ChessPiece extends PieceBG {

    private Color color;

    public ChessPiece(Board board, Color color) {
        // Nesse super, ele repassa a chamada para o contrutor da SuperClasse
        // Que é o contrutor da classe PieceBG
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
