import java.util.List;
import java.util.ArrayList;

/**
 * Tester of Matrix and MatrixMath classes
 */
public class MatrixTester
{
    public static void main(String[] args)
    {
        testAddition();
        testSubtraction();
        testMultiplication();
        testScalarMultiplication();
        testTranspose();
        testDeterminant();
        testInverse();
        testAreaOfTriangle();
    }

    /**
     * Tests addition method of MatrixMath class
     */
    public static void testAddition()
    {
        double[][] values1 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {3, 8, 5, 2}, {1, 3, 5, 7} };
        double[][] values2 = { {1, 5, 3, 1}, {2, 9, 6, 8}, {3, 5, 2, 1}, {8, 5, 3, 7} };
        double[][] values3 = { {3, 5, 4}, {1, 5, 3}, {2, 7, 4} };
        double[][] values4 = { {2, 7, 6, 5}, {9, 15, 11, 12}, {6, 13, 7, 3}, {9, 8, 8, 14} };
        Matrix addition1 = new Matrix(values1);
        Matrix addition2 = new Matrix(values2);
        Matrix addition3 = new Matrix(values3);
        Matrix expectedValue1 = new Matrix(values4);
        System.out.println("MatrixTester.testAddition");
        System.out.println(addition1 + "+\n" + addition2 + "=\n" + MatrixMath.add(addition1, addition2));
        System.out.println("Expected value:\n" + expectedValue1 + "\n");
        System.out.println(addition1 + "+\n" + addition3 + "=\n" + MatrixMath.add(addition1, addition3));
        System.out.println("Expected value: Nothing - dimensions do not match.");
        System.out.println("==================================================");
    }

    /**
     * Tests subtraction method of MatrixMath class
     */
    public static void testSubtraction()
    {
        double[][] values1 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {3, 8, 5, 2}, {1, 3, 5, 7} };
        double[][] values2 = { {1, 5, 3, 1}, {2, 9, 6, 8}, {3, 5, 2, 1}, {8, 5, 3, 7} };
        double[][] values3 = { {3, 5, 4}, {1, 5, 3}, {2, 7, 4} };
        double[][] values4 = { {0, -3, 0, 3}, {5,  -3, -1,  -4}, {0, 3, 3, 1}, {-7, -2, 2, 0} };
        Matrix subtraction1 = new Matrix(values1);
        Matrix subtraction2 = new Matrix(values2);
        Matrix subtraction3 = new Matrix(values3);
        Matrix expectedValue1 = new Matrix(values4);
        System.out.println("MatrixTester.testSubtraction");
        System.out.println(subtraction1 + "-\n" + subtraction2 + "=\n" + MatrixMath.subtract(subtraction1, subtraction2));
        System.out.println("Expected value:\n" + expectedValue1 + "\n");
        System.out.println(subtraction1 + "-\n" + subtraction3 + "=\n" + MatrixMath.subtract(subtraction1, subtraction3));
        System.out.println("Expected value: Nothing - dimensions do not match.");
        System.out.println("==================================================");
    }

    /**
     * Tests multiplication method of MatrixMath class
     */
    public static void testMultiplication()
    {
        double[][] values1 = { {1, 2, 3}, {4, 5, 6} };
        double[][] values2 = { {7, 8}, {9, 10}, {11, 12} };
        double[][] values3 = { {5, 3}, {1, -1} };
        double[][] values4 = { {58, 64}, {139, 154} };
        Matrix multiply1 = new Matrix(values1);
        Matrix multiply2 = new Matrix(values2);
        Matrix multiply3 = new Matrix(values3);
        Matrix expectedValue1 = new Matrix(values4);
        System.out.println("MatrixTester.testMultiplication");
        System.out.println(multiply1 + "x\n" + multiply2 + "=\n" + MatrixMath.multiply(multiply1, multiply2));
        System.out.println("Expected value:\n" + expectedValue1 + "\n");
        System.out.println(multiply1 + "x\n" + multiply3 + "=\n" + MatrixMath.multiply(multiply1, multiply3));
        System.out.println("Expected value: Nothing - dimensions are not able to be multiplied");
        System.out.println("==================================================");
    }

    /**
     * Tests scalarMultiplication method of MatrixMath class
     */
    public static void testScalarMultiplication()
    {
        double[][] values1 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {7, 8, 9, 10} };
        double[][] values2 = { {5, 10, 15, 20}, {35, 30, 25, 20}, {35, 40, 45, 50} };
        Matrix multiply1 = new Matrix(values1);
        Matrix expectedValue1 = new Matrix(values2);
        System.out.println("MatrixTester.testScalarMultiplication");
        System.out.println("5\nx\n" + multiply1 + "=\n" + MatrixMath.scalarMultiply(5, multiply1));
        System.out.println("Expected value: " + expectedValue1);
        System.out.println("==================================================");
    }

    /**
     * Tests transpose method of MatrixMath class
     */
    public static void testTranspose()
    {
        double[][] values1 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {7, 8, 9, 10} };
        double[][] values2 = { {1, 7, 7}, {2, 6, 8}, {3, 5, 9}, {4, 4, 10} };
        Matrix transpose1 = new Matrix(values1);
        Matrix expectedValue1 = new Matrix(values2);
        System.out.println("MatrixTester.testTranspose");
        System.out.println(transpose1 + "\nTransposed: \n" + MatrixMath.transpose(transpose1));
        System.out.println("Expected value:\n" + expectedValue1);
        System.out.println("==================================================");
    }

    /**
     * Tests determinant method of MatrixMath class
     */
    public static void testDeterminant()
    {
        double[][] values1 = { {3, 8}, {4, 6} };
        double[][] values2 = { {6, 1, 1}, {4, -2, 5}, {2, 8, 7} };
        double[][] values3 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {7, 8, 9, 10} };
        Matrix det1 = new Matrix(values1);
        Matrix det2 = new Matrix(values2);
        Matrix det3 = new Matrix(values3);
        System.out.println("MatrixTester.testDeterminant");
        System.out.println("Determinant of\n" + MatrixMath.determinant(det1));
        System.out.println("Expected value: -14\n");
        System.out.println("Determinant of\n" + MatrixMath.determinant(det2));
        System.out.println("Expected value: -306\n");
        System.out.println("Determinant of\n" + MatrixMath.determinant(det3));
        System.out.println("Expected value: Nothing - matrix is not square.\n");
        System.out.println("==================================================");
    }

    /**
     * Tests inverse method of MatrixMath class
     */
    public static void testInverse()
    {
        double[][] values1 = { {3, 8}, {4, 6} };
        double[][] values2 = { {6, 1, 1}, {4, -2, 5}, {2, 8, 7} };
        double[][] values3 = { {1, 2, 3, 4}, {7, 6, 5, 4}, {7, 8, 9, 10} };
        double[][] values4 = { {-0.429, 0.571}, {0.286, -0.214} };
        double[][] values5 = { {0.176, -0.003, -0.023}, {0.059, -0.131, 0.084}, {-0.118, 0.150, 0.052} };
        Matrix inverse1 = new Matrix(values1);
        Matrix inverse2 = new Matrix(values2);
        Matrix inverse3 = new Matrix(values3);
        Matrix expectedValue1 = new Matrix(values4);
        Matrix expectedValue2 = new Matrix(values5);
        System.out.println("MatrixTester.testInverse");
        System.out.println("Inverse of\n" + inverse1 + "=\n" + MatrixMath.inverse(inverse1));
        System.out.println("Expected value:\n" + expectedValue1);
        System.out.println("Inverse of\n" + inverse2 + "=\n" + MatrixMath.inverse(inverse2));
        System.out.println("Expected value:\n" + expectedValue2);
        System.out.println("Inverse of\n" + inverse3 + "=\n" + MatrixMath.inverse(inverse3));
        System.out.println("Expected value: Nothing - matrix is not square.");
        System.out.println("==================================================");
    }

    /**
     * Tests areaofTriangle method of MatrixMath class
     */
    public static void testAreaOfTriangle()
    {
        System.out.println(MatrixMath.areaOfTriangle());
    }

}
