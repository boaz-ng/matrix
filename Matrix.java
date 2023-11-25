import java.text.DecimalFormat;

/**
 * Simulates a matrix
 * @author boaz.ng
 */
public class Matrix
{
    private int rows;
    private int columns;
    private double[][] values;

    /**
     * Creates a matrix of 0's with given dimensions
     * @param rows Number of rows in the matrix
     * @param columns Number of columns in the matrix
     */
    public Matrix(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.values = new double[rows][columns];
    }

    /**
     * Creates a matrix given an int[][] of values
     * @param inputMatrix int[][] with values to be inputed into matrix
     */
    public Matrix(double[][] inputMatrix)
    {
        this.rows = inputMatrix.length;
        this.columns = inputMatrix[0].length;
        this.values = new double[rows][columns];
        for (int i = 0; i < inputMatrix.length; i++)
        {
            for (int j = 0; j < inputMatrix[i].length; j++)
            {
                this.values[i][j] = format(inputMatrix[i][j]);
            }
        }
    }

    /**
     * Returns the number of rows in the matrix
     * @return the number of rows in the matrix
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * Returns the number of columns in the matrix
     * @return the number of columns in the matrix
     */
    public int getColumns()
    {
        return columns;
    }

    /**
     * Returns the int[][] of values in the matrix
     * @return the values in the matrix
     */
    public double[][] getValues()
    {
        return values;
    }

    /**
     * Returns the number in a particular row and column
     * @param row the row of the number
     * @param column the column of the number
     * @return the number in the row and column
     */
    public double getNumber(int row, int column)
    {
        return values[row][column];
    }

    /**
     * Sets the number in row "row" and column "column" to "num"
     * @param num Value replacing the old value
     * @param row Row of replaced value
     * @param column Column of replaced value
     */
    public void setNumber(double num, int row, int column)
    {
        values[row][column] = format(num);
    }

    /**
     * Represents the matrix as a String with each number followed by a space.
     * Each row is followed by \n.
     */
    @Override
    public String toString()
    {
        String a = "";
        for (double[] row : values)
        {
            for (double num : row)
            {
                a += num;
                a += " ";
            }
            a += "\n";
        }
        return a;
    }

    /**
     * Compares current matrix with inputted matrix mat, returns true if identical, false otherwise
     * @param mat Matrix to be compared against
     * @return If all values in the matrices are identical, return true
     *         Otherwise, return false
     */
    public boolean equals(Matrix mat)
    {
        boolean doesEqual = true;
        for (int i = 0; i < this.getRows(); i++)
        {
            for (int j = 0; j < this.getColumns(); j++)
            {
                if (this.getNumber(i, j) != mat.getNumber(i, j))
                {
                    doesEqual = false;
                }
            }
        }
        if (this.getRows() != mat.getRows() && this.getColumns() != mat.getColumns())
        {
            doesEqual = false;
        }
        return doesEqual;
    }

    /**
     * Formats a double such that it has a maximum of 3 decimal places
     * @param num Original double
     * @return Formatted double
     */
    private static double format(double num)
    {
        DecimalFormat df = new DecimalFormat("#.###");
        String formatted = df.format(num);
        return (Double.parseDouble(formatted));
    }
}
