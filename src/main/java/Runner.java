public class Runner {
    public static void main(String[] args) {
//        Matrix2D m1 = Matrix2D.createMatrixWithZeroOrOne(4, 4);
//
//        Matrix2D m2 = Matrix2D.createMatrixWithZeroOrOne(4, 4);
//
//        Matrix2D m3 = m2.plus(m1);
//
//        for (int i = 1; i <= m3.getRowLength(); i++) {
//            for (int j = 1; j <= m3.getColLength(); j++) {
//                System.out.print(m3.get(new Index2D(i, j)) + " ");
//            }
//            System.out.println();
//        }


        Matrix3D m1 = new Matrix3D(1, 1, 1);
        m1.put(new Index3D(1, 1, 1), 10);

        Matrix3D m2 = new Matrix3D(1, 1, 1);
        m2.put(new Index3D(1, 1, 1), 5);

        Matrix3D plus = m2.plus(m1);
        System.out.println(plus.get(new Index3D(1, 1, 1)));

    }
}
