import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Matrix2D {
    private Map<Index2D, Integer> values; // (x,y) -> v ... (
    private int rowLength;
    private int colLength;

    public Matrix2D() {
    }

    public Matrix2D(int rowLength, int colLength) {
        values = new HashMap<>();
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                values.put(new Index2D(i,j), 0);
            }
        }
        this.rowLength = rowLength;
        this.colLength = colLength;
    }

    public static Matrix2D createMatrixWithZeroOrOne(int rowLength, int colLength) {
        Random random = new Random();

        Matrix2D result = new Matrix2D(rowLength, colLength);
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                if (random.nextBoolean()) {
                    result.put(new Index2D(i, j), 1);
                } else {
                    result.put(new Index2D(i,j), 0);
                }
            }
        }
        return result;
    }

    public Matrix2D plus(Matrix2D matrix2D) throws RuntimeException {
        if (matrix2D == null) {
            throw new NullPointerException();
        }

        if (!(matrix2D.getRowLength() == this.rowLength &&
                matrix2D.getColLength() == this.colLength)) {
            throw new RuntimeException("Matrices cannot be of different dimensions");
        }

        Matrix2D result = new Matrix2D(rowLength, colLength);

        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                Index2D index = new Index2D(i, j);
                Integer integer = this.get(index);
                Integer integer1 = matrix2D.get(index);
                int value = integer + integer1;
                result.put(index, value);
            }
        }
        return result;
    }


    public void put(Index2D index, Integer value) {
        if (index.getRow() > rowLength || index.getCol() > colLength) {
            throw new IllegalArgumentException();
        }
        this.values.put(index, value);
    }

    public Integer get(Index2D index2D) {
        Integer integer = this.values.get(index2D);
        return integer;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getColLength() {
        return colLength;
    }

    public void setColLength(int colLength) {
        this.colLength = colLength;
    }
}
