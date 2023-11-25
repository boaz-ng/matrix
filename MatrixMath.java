import java.util.Scanner;

/**
 * Contains basic operations of matrices
 */
public class MatrixMath
{
    /**
     * Adds Matrix mat1 and Matrix mat2
     * @param mat1 First matrix to be added
     * @param mat2 Second matrix to be added
     * @return If mat1 and mat2 have the same dimensions, returns added matrix
     *         If mat1 and mat2 have different dimensions, returns empty matrix
     */
    public static Matrix add(Matrix mat1, Matrix mat2)
    {
        if (mat1.getRows() == mat2.getRows() && mat1.getColumns() == mat2.getColumns())
        {
            Matrix newMatrix = new Matrix(mat1.getRows(), mat1.getColumns());
            for (int i = 0; i < newMatrix.getRows(); i++)
            {
                for (int j = 0; j < newMatrix.getColumns(); j++)
                {
                    newMatrix.setNumber(mat1.getNumber(i, j) + mat2.getNumber(i, j), i, j);
                }
            }
            return newMatrix;
        }
        else
        {
            return (new Matrix(0, 0));
        }
    }

    /**
     * Subtracts Matrix mat2 from Matrix mat1
     * @param mat1 First matrix to be subtracted from
     * @param mat2 Second matrix to subtract
     * @return If mat1 and mat2 have the same dimensions, returns difference matrix
     *         If mat1 and mat2 have different dimensions, returns empty matrix
     */
    public static Matrix subtract(Matrix mat1, Matrix mat2)
    {
        if (mat1.getRows() == mat2.getRows() && mat1.getColumns() == mat2.getColumns())
        {
            Matrix newMatrix = new Matrix(mat1.getRows(), mat1.getColumns());
            for (int i = 0; i < newMatrix.getRows(); i++)
            {
                for (int j = 0; j < newMatrix.getColumns(); j++)
                {
                    newMatrix.setNumber(mat1.getNumber(i, j) - mat2.getNumber(i, j), i, j);
                }
            }
            return newMatrix;
        }
        else
        {
            return (new Matrix(0, 0));
        }
    }

    /**
     * Multiplies two matrices mat1 and mat2
     * @param mat1 First matrix to be multiplied
     * @param mat2 Second matrix to be multiplied
     * @return If matrices mat1 and mat2 are able to be multiplied, returns product
     *         If dimensions are not compatible, returns empty matrix
     */
    public static Matrix multiply(Matrix mat1, Matrix mat2)
    {
        if (mat1.getColumns() == mat2.getRows())
        {
            Matrix newMatrix = new Matrix(mat1.getRows(), mat2.getColumns());
            for (int i = 0; i < newMatrix.getRows(); i++)
            {
                for (int j = 0; j < newMatrix.getColumns(); j++)
                {
                    double sum = 0; // row i * column j
                    for (int k = 0; k < mat1.getColumns(); k++)
                    {
                        sum += mat1.getNumber(i, k) * mat2.getNumber(k, j);
                    }
                    newMatrix.setNumber(sum, i, j);
                }
            }
            return (newMatrix);
        }
        else
        {
            return (new Matrix(0, 0));
        }
    }

    /**
     * Multiplies each element in a matrix mat1 by a scalar scalar
     * @param scalar Number by which matrix is multiplied by
     * @param mat1 Original matrix
     * @return Scaled matrix
     */
    public static Matrix scalarMultiply(double scalar, Matrix mat1)
    {
        for (int i = 0; i < mat1.getRows(); i++)
        {
            for (int j = 0; j < mat1.getColumns(); j++)
            {
                double value = mat1.getNumber(i, j);
                mat1.setNumber(value * scalar, i, j);
            }
        }
        return mat1;
    }

    /**
     * Transposes inputted matrix mat1 such that the value in position (i, j) is
     * in the position (j, i) in the transposed matrix.
     * @param mat1 Matrix to be transposed
     * @return Transposed matrix
     */
    public static Matrix transpose(Matrix mat1)
    {
        Matrix transposed = new Matrix(mat1.getColumns(), mat1.getRows());
        for (int i = 0; i < mat1.getRows(); i++)
        {
            for (int j = 0; j < mat1.getColumns(); j++)
            {
                transposed.setNumber(mat1.getNumber(i, j), j, i);
            }
        }
        return transposed;
    }

    /**
     * Calculates determinant of a square matrix mat1
     * @param mat1 Original matrix
     * @return If matrix is square, returns determinant
     *         If matrix is not square, returns 0
     */
    public static double determinant(Matrix mat1)
    {
        if (mat1.getRows() == mat1.getColumns())
        {
            int sign = 1;
            double sum = 0;
            if (mat1.getRows() == 1)
            {
                return mat1.getNumber(0, 0);
            }
            for (int i = 0; i < mat1.getColumns(); i++)
            {
                sum += sign * mat1.getNumber(0, i) * determinant(removeRowAndColumn(0, i, mat1));
                sign *= -1;
            }
            return sum;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Returns the inverse of a matrix mat1 using "Minors, Cofactors, and Adjugate"
     * (https://www.mathsisfun.com/algebra/matrix-inverse-minors-cofactors-adjugate.html)
     * @param mat1 Matrix to find the inverse of
     * @return If inverse exists, returns inverse.
     *         If inverse does not exist, returns empty matrix.
     */
    public static Matrix inverse(Matrix mat1)
    {
        if (determinant(mat1) == 0 || mat1.getRows() != mat1.getColumns())
        {
            return (new Matrix(0, 0));
        }
        Matrix temp = new Matrix(mat1.getRows(), mat1.getColumns());
        Matrix inverse = new Matrix(mat1.getRows(), mat1.getColumns());
        for (int i = 0; i < mat1.getRows(); i++)
        {
            for (int j = 0; j < mat1.getColumns(); j++)
            {
                temp.setNumber(determinant(removeRowAndColumn(i, j, mat1)), i, j);
            }
        }
        int sign = 1;
        for (int i = 0; i < mat1.getRows(); i++)
        {
            for (int j = 0; j < mat1.getColumns(); j++)
            {
                temp.setNumber(sign * temp.getNumber(i, j), i, j);
                sign *= -1;

            }
            if (mat1.getRows() % 2 == 0)
            {
                sign *= -1;
            }
        }
        for (int i = 0; i < mat1.getRows(); i++)
        {
            for (int j = 0; j < mat1.getColumns(); j++)
            {
                inverse.setNumber(temp.getNumber(i, j) / MatrixMath.determinant(mat1), j, i);
            }
        }
        return inverse;
    }

    /**
     * Inputs coordinate values from user, then uses the determinant to find the area of the triangle formed.
     * @return Area of formed triangle
     */
    public static double areaOfTriangle()
    {
        double[][] coords = new double[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the coordinates of the first point in the form \"x y\".");
        coords[0][0] = sc.nextDouble();
        coords[0][1] = sc.nextDouble();
        coords[0][2] = 1;
        System.out.println("Please enter the coordinates of the second point.");
        coords[1][0] = sc.nextDouble();
        coords[1][1] = sc.nextDouble();
        coords[1][2] = 1;
        System.out.println("Please enter the coordinates of the third point.");
        coords[2][0] = sc.nextDouble();
        coords[2][1] = sc.nextDouble();
        coords[2][2] = 1;
        Matrix values = new Matrix(coords);
        return (Math.abs(0.5 * determinant(values)));
    }

    /**
     * Removes row deletedRow and column deletedColumn from a matrix mat1
     * @param deletedRow Index of the row to be deleted
     * @param deletedColumn Index of the column to be deleted
     * @param mat1 Original matrix to be modified
     * @return Matrix with row and column removed
     */
    private static Matrix removeRowAndColumn(int deletedRow, int deletedColumn, Matrix mat1)
    {
        Matrix newMatrix = new Matrix(mat1.getRows() - 1, mat1.getColumns() - 1);
        int rowCounter = 0;
        int columnCounter = 0;
        for (int oldRow = 0; oldRow < mat1.getRows(); oldRow++)
        {
            for (int oldColumn = 0; oldColumn < mat1.getColumns(); oldColumn++)
            {
                if (oldRow != deletedRow && oldColumn != deletedColumn)
                {
                    double oldNumber = mat1.getNumber(oldRow, oldColumn);
                    newMatrix.setNumber(oldNumber, rowCounter, columnCounter);
                    columnCounter++;
                    if (columnCounter == newMatrix.getRows())
                    {
                        columnCounter = 0;
                        rowCounter++;
                    }
                }
            }
        }
        return newMatrix;
    }
}
