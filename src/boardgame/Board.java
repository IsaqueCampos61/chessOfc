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
}
