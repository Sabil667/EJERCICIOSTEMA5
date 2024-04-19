package SumaNumerosN;

public class NumerosN {
    public static int sumaRecursiva(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumaRecursiva(n - 1);
        }
    }
}