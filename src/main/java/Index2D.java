public class Index2D {
    private int row;
    private int col;

    public Index2D() {
    }

    public Index2D(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Index2D)) return false;

        Index2D index2D = (Index2D) o;

        if (row != index2D.row) return false;
        return col == index2D.col;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
