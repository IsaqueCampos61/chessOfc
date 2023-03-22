package boardgame;

//Metodo protectecd para que não seja visivel na camada principal de xadrez
public class PieceBG {

    protected Position position;
    private Board board;

    public PieceBG(Board board) {
        this.board = board;
        position = null;
    }

    //Somente classes dentro do mesmo pacote e sub classes poderão acessar o tabuleiro de um peça
    protected Board getBoard() {
        return board;
    }
}
