import java.util.HashMap;
import java.util.Map;

public class Matrix3D extends Matrix2D {
    private Map<Index3D, Integer> values;
    private int heightLength;

    public Matrix3D(int rowLength, int colLength, int heightLength) {
        super.setRowLength(rowLength);
        super.setColLength(colLength);
        this.heightLength = heightLength;

        values = new HashMap<>();

        for (int i = 1; i <= getRowLength(); i++) {
            for (int j = 1; j <= getColLength(); j++) {
                for (int k = 1; k <= heightLength; k++) {
                    values.put(new Index3D(i,j,k), 0);
                }
            }
        }
    }

    public Matrix3D plus(Matrix3D matrix3D) throws RuntimeException {
        Matrix3D result = new Matrix3D(this.getRowLength(), this.getColLength(), heightLength);
        for (int i = 1; i <= heightLength; i++) {
            Matrix2D plus = this.get2DMatrix(i).plus(matrix3D.get2DMatrix(i));
            result.put2DMatrix(plus, i);
        }
        return result;
    }

    private Matrix2D get2DMatrix(int i) {
        Matrix2D result = new Matrix2D(getRowLength(), getColLength());
        for (int j = 1; j <= result.getRowLength(); j++) {
            for (int k = 1; k <= result.getColLength(); k++) {
                Integer value = this.get(new Index3D(j, k, i));
                result.put(new Index2D(j, k), value);
            }
        }
        return result;
    }

    private void put2DMatrix(Matrix2D matrix2D, int height) {
        for (int j = 1; j <= getRowLength(); j++) {
            for (int k = 1; k <= getColLength(); k++) {
                values.put(new Index3D(j,k,height), matrix2D.get(new Index2D(j,k)));
            }
        }
    }

    public void put(Index3D index, Integer value) {
        this.values.put(index, value);
    }

    public Integer get(Index3D index) {
        return this.values.get(index);
    }

    public int getHeightLength() {
        return heightLength;
    }

    public void setHeightLength(int heightLength) {
        this.heightLength = heightLength;
    }
}
