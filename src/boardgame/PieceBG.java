package boardgame;

//Metodo protectecd para que não seja visivel na camada principal de xadrez
public abstract class PieceBG {

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

    //Essa é uma operação abstrata
    public abstract boolean[][] possibleMoves ();

    //Essa recebe uma posiçao e retorna vardadeiro ou falso
    // ou seja se é possivel mover para uma determiada posição
    //E um metodo concreto que ultiliza um metodo abstrato
    public boolean possibleMoves (Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    //Esse metodo testa para saber se a peça tem ao menos um movimento possivel
    //ou se está presa
    public boolean isThereAnyPossibleMove(){
        boolean [][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++ ){
            for (int j = 0; j < mat.length; j++){
                if (mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
