package boardgame;

public class Board {

    private int rows;
    private int columns;
    private PieceBG[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        // a matriz está sendo instanciada recebendo rows e columns informados pelo contrutor
        pieces = new PieceBG[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    //Aqui o nome do metodo é piece do tipo PieceBG
    //ele recebe o int row e int column
    //ele retorna a matriz (pieces) na row e column informadas pelo metodo
    public PieceBG piece(int row, int column){
        return pieces[row][column];
    }

    //aqui temos uma sobrecarga do metodo acima
    //porém nessa operação ele esta recebendo uma posição do tipo(Position)
    public PieceBG piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }


}
