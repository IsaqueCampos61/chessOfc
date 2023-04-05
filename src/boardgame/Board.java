package boardgame;

public class Board {

    private int rows;
    private int columns;
    private PieceBG[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1 ){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        // a matriz está sendo instanciada recebendo rows e columns informados pelo contrutor
        pieces = new PieceBG[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //Aqui o nome do metodo é piece do tipo PieceBG
    //ele recebe o int row e int column
    //ele retorna a matriz (pieces) na row e column informadas pelo metodo
    public PieceBG piece(int row, int column ){
        //essa exclamação da a ideia contraria, (ou seja se a posição não existe)
        if (!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    //aqui temos uma sobrecarga do metodo acima
    //porém nessa operação ele esta recebendo uma posição do tipo(Position)
    public PieceBG piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(PieceBG piece, Position position ){
        if (thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        //Aqui ele prga a matriz na posição dada por getRow e getColumn
        //Atribuindo a ela a peça(piece) informada
        pieces[position.getRow()][position.getColumn()] = piece;
        //aqui informamos que piece não é mais nulo
        piece.position = position;
    }

    //Operação para remover uma peça recebendo um POsition como argumento
    /*o primeiro if è a programção defenciva da operação,
     ele testa se a posição passada como argumento existe ou não,
     caso não exista cai na exceção
     */
    /*o segundo if, testa para saber se tem alguma peça na posicção
    caso nâo tenha ele rtorna null
    */
    //cso a operação passe os dois if, ai sim ela retira uma peça do tabuleiro
    public PieceBG removePiece (Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if (piece (position) == null ){
            return null;
        }
        /* Essa nova variavel aux do tipo PieceBG
        vai receber a piece que esta no tabuleiro na postion informada */
        PieceBG aux = piece (position);
        // agora estamos informando que a posição de aux vai ser null
        // assim a peça foi retirada do tabuleiro
        aux.position = null;
        /* na matrix pieces nessa position passada como argumento
        (aonde esta sendo removida a peça) agora passa a ser null */
        //Logo não tem mais peça nessa posição da matrix
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    //esse atua como um metodo auxiliar ao metodo de baixo
    /* esse metodo auxiliar é realizado por que em um determiando momento
    vai ser mais viavel testar uma posição pala linha e coluna*/
    private boolean positionExists (int row, int column){
        //isso é a condição completa para saber se a posição existe
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists (Position position){
        // dessa forma reproveitamos o metodo de cima
        return positionExists(position.getRow(), position.getColumn());
    }

    // Esse metodo testa se existe uma peça em determinada posição
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
