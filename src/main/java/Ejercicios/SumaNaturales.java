package Ejercicios;

public class SumaNaturales {
    public static int sumaRecursiva(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + sumaRecursiva(n - 1);
        }
    }
}