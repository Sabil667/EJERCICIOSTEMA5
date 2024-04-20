package Ejercicios;

public class calcularC {
    public static int calcularCombinatoria(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calcularCombinatoria(n - 1, k - 1) + calcularCombinatoria(n - 1, k);
        }
    }
}