package boardgame;

public class Position {

    private int row;
    private int column;

    public Position(){
    }

    public Position(int row, int column) {
        //operação denominada (Contrutor)
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    //o @Override Está sobreescrevendo o metodo toString
    //O metodo toString é do tipo (object), que é uma superclasse de todas as classes
    public String toString() {
        return row + ", " + column;
    }
}